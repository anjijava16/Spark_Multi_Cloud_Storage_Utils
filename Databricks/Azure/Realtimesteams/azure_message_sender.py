import time
import os
import json
from azure.eventhub import EventHubProducerClient, EventData


CONNECTION_STR = 'Endpoint=sb://iwinnertopicnamespace.servicebus.windows.net/;SharedAccessKeyName=ordersas;SharedAccessKey=6/eNo+1AhXbC+6bPOpJTbFi0ncx327Tl8PHlY9E+SG4=;EntityPath=orderjobstopic'
EVENTHUB_NAME = 'orderjobstopic'


start_time = time.time()

producer = EventHubProducerClient.from_connection_string(
    conn_str=CONNECTION_STR,
    eventhub_name=EVENTHUB_NAME
)
to_send_message_cnt = 500
bytes_per_message = 256

with producer:
    event_data_batch = producer.create_batch()
    for i in range(to_send_message_cnt):
        reading = {'source': 'wind-turbine-geo-sensor','id': str(i)}
        s = json.dumps(reading)           
        print(s)
        event_data = EventData(s)
        try:
            event_data_batch.add(event_data)
        except ValueError:
            producer.send_batch(event_data_batch)
            event_data_batch = producer.create_batch()
            event_data_batch.add(event_data)
    if len(event_data_batch) > 0:
        producer.send_batch(event_data_batch)

print("Send messages in {} seconds.".format(time.time() - start_time))