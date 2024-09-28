# Database

Endpoints <br>

curl --location 'http://localhost:8080/saveRanking' \
--header 'Content-Type: application/json' \
--data '{
"nome":"Teste",
"tempo":17.0,
"dificuldade": "fácil"
}'    ---> responsavel por salvar no banco


curl --location 'http://localhost:8080/api/jogo/hello?dificuldade=fácil' \
--data ''  --> responsavel por pegar o ranking por nivel