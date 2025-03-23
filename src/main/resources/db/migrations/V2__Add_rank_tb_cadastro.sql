-- Migrations para adicionar a coluna de rank na tb_cadastro

ALTER TABLE tb_cadastro
ADD COLUMN rank varchar(255);