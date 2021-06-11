import sys
from kafka import KafkaConsumer
import json

print("Starting consumer")

consumer = KafkaConsumer(
    'cookie-topic',
    bootstrap_servers = ['kafka:29092'],
#    auto_offset_reset = 'earliest',
    enable_auto_commit = True,
#    group_id = 'consumer-group-0',
    value_deserializer = lambda m: json.loads(m.decode('utf-8'))
)

for message in consumer:
    try:
        cookie_order = message.value
        print('I got a {} cookie!'.format(cookie_order['type']))
    except:
        print("Vish", sys.exec_info()[0])
