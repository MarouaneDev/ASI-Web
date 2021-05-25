function displayCards(cardList) {
    let template = document.querySelector("#row");

    for (const card of cardList) {
        let clone = document.importNode(template.content, true);

        newContent = clone.firstElementChild.innerHTML
            .replace(/{{family_name}}/g, card.family)
            .replace(/{{img_src}}/g, card.imgurl)
            .replace(/{{name}}/g, card.name)
            .replace(/{{description}}/g, card.description)
            .replace(/{{hp}}/g, card.hp)
            .replace(/{{energy}}/g, card.energy)
            .replace(/{{attack}}/g, card.attack)
            .replace(/{{defence}}/g, card.defence)
            .replace(/{{price}}/g, card.price);
        clone.firstElementChild.innerHTML = newContent;

        let cardContainer = document.querySelector("#tableContent");
        cardContainer.appendChild(clone);
    }
}


function buyCard(cardId){
    $.ajax({
        type: 'POST',
        url: '/buy/carte/'+cardId,
        data: {
            'userId': document.getElementById("userNameId").innerText,
        },
        success: function(msg){
            alert('Card with ID ' + cardId + ' has been successfully bought');
        }
    });
}

$.ajax({
    url: "/cartes",
    contentType: "application/json",
    context: document.body
}).done(function(response) {
    displayCards(response);
});