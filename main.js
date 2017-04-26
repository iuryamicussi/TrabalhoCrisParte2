// JavaScript Document
var tentativas =0;
var numeroSorteado;
var achou = false;
function loopGame(range)
{
	sortearNumero(range);
	while(!achou)
	{
		var tentativa = prompt("Digite um número de 0 a " + range);
		if (tentativa == numeroSorteado)
		{
			achou = true;
			alert("Você acertou com " + tentativas + " !\n Bauzao!");	
		}
		else
		{
			if (tentativa == "sair")
			{
				achou = true;
			}
			if(isNaN(tentativa))
			{
				alert("Digite um número. N-Ú-M-E-R-O!!!");
			}
			else
			{
				if(tentativa>numeroSorteado)
					alert("Número muito alto");
				else
					alert("Número muito baixo");	
				tentativas++;
			}
		}
	}
}
function sortearNumero(range)
{
	numeroSorteado = Math.floor(Math.random() * range);
}