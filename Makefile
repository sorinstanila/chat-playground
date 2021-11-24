.PHONY: up init

up:
	@echo "---> Running broker(s) container..."
	@docker-compose up -d activemq --remove-orphans
	@docker-compose up -d activemq-upgrade --remove-orphans
	@docker-compose up -d artemis --remove-orphans
	@docker-compose up -d rabbitmq --remove-orphans
	@echo "Done."

down:
	@echo "---> Stopping broker(s) container(s)..."
	@docker-compose stop activemq
	@docker-compose stop activemq-upgrade
	@docker-compose stop artemis
	@docker-compose stop rabbitmq
	@echo "Exited."