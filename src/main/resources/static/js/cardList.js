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
            .replace(/{{defense}}/g, card.defense)
            .replace(/{{price}}/g, card.price);
        clone.firstElementChild.innerHTML = newContent;

        let cardContainer = document.querySelector("#tableContent");
        cardContainer.appendChild(clone);
    }
}

$.ajax({
    url: "/cartes",
    contentType: "application/json",
    context: document.body
}).done(function(response) {
    displayCards(response);
});