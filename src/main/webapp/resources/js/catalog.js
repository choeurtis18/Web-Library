const newDocButton = document.querySelector("#new-doc-btn");
const closeModal = document.querySelector("#close-modal-btn");
const modal = document.querySelector(".modal");
const typeSelect = document.querySelector(".select>select");

newDocButton.addEventListener('click', () => {
    const modalContainer = document.querySelector("#new-doc-modal");
    modalContainer.classList.add("is-active");
});

closeModal.addEventListener('click', () => {
    modal.classList.remove("is-active");
});

typeSelect.addEventListener('change', e => {
    const type = e.target.value;
    const label = document.querySelector("#optional-field>label");
    const optionalInput = document.querySelector("#optional-field .control>input");

    switch (type) {
        case "1":
            label.textContent = "Author";
            optionalInput.getAttributeNode("placeholder").textContent = "Enter an author";
            optionalInput.getAttributeNode("name").textContent = "author";
            break;
        case "2":
            label.textContent = "Artist";
            optionalInput.getAttributeNode("placeholder").textContent = "Enter an artist";
            optionalInput.getAttributeNode("name").textContent = "artist";
            break;
        case "3":
            label.textContent = "Producer";
            optionalInput.getAttributeNode("placeholder").textContent = "Enter a producer";
            optionalInput.getAttributeNode("name").textContent = "producer";
            break;
    }
});

$("#new-doc-save-btn").click(() => {
    $.ajax({
        type: "POST",
        url: "localhost:8080/document/new",
        data: $("#new-document-form").serialize(),
        success: () => {},
        dataType: "json"
    });
});