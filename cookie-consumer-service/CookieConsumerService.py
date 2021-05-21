from kafka import KafkaConsumer

consumer = KafkaConsumer(
    'cookie-topic',
    bootstrap_servers=['localhost:9092'],
    auto_offset_reset='earliest',
    enable_auto_commit=True,
    group_id='consumer-group-0'
)

for message in consumer:
    message_value = message.value
    print('I got a {} cookie!'.format(message_value))
