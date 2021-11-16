CREATE TABLE IF NOT EXISTS transactions (
	"id" uuid DEFAULT gen_random_uuid() PRIMARY KEY,
	"type" INT not null,
	"date" VARCHAR(10) not null,
	"hour" VARCHAR(10) not null,
	"value" NUMERIC not null,
	"cpf" VARCHAR(11) not null,
	"card" VARCHAR(12) not null,
	"store_owner" TEXT not null,
	"store_name" TEXT not null
);