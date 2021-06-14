# First stage
FROM python:3.8 AS builder

COPY requirements.txt .

# Install dependencies to the local user directory (/root/.local)
RUN pip install --user -r requirements.txt


# Second stage
FROM python:3.8-slim

WORKDIR /code

COPY --from=builder /root/.local /root/.local

COPY ./src .

ENV PATH=/root/.local:$PATH

CMD ["python", "./CookieConsumerService.py"]

# docker image build --tag cookie-consumer-service .
# docker container run -it --rm --network learningkafka_default cookie-consumer-service