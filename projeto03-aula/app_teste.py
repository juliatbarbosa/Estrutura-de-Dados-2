from Tarefa import Task

obj = Task("Lavar roupa")
outro = Task("Fazer almoço")
outro.set_descricao('Descrição do outro objeto')

print(obj.info())
print('-'*30)
print(outro.info())