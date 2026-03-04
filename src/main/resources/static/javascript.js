
document.getElementById("permutaForm").addEventListener("submit", async function (event) {
    event.preventDefault(); 

    const data = {
        nomeSubstituto: document.getElementById("nomeSubstituto").value,
        nomeEscalado: document.getElementById("nomeEscalado").value,
        secaoSubstituto: document.getElementById("secaoSubstituto").value,
        secaoEscalado: document.getElementById("secaoEscalado").value,
        postoServico: document.getElementById("postoServico").value,
        dataServico: document.getElementById("dataServico").value
    };

    try {
        const response = await fetch("http://localhost:8080/pdf/gerar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error("Erro ao gerar documento");
        }

      
        const blob = await response.blob();            

    
        const url = window.URL.createObjectURL(blob);
        const a = document.createElement("a");
        a.href = url;
        a.download = "permuta.pdf";
        document.body.appendChild(a);
        window.open(url, "_blank");
        a.click();
        a.remove();

        window.URL.revokeObjectURL(url);

    } catch (error) {
        alert("Erro ao gerar documento");
        console.error(error);
    }
});