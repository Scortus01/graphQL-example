# graphQL-example

Url: localhost:8080/graphql

Create Author:

{
  "query": "mutation { createAuthor(id: \"1\", name: \"Braian\", thumbnail: \"\") { id, name, thumbnail } }"
}

Create Post:

{
  "query": "mutation { createPost(id: \"1\", title: \"Nuevo Post\", text: \"Contenido del nuevo post\", category: \"General\", authorId: \"1\") { id, title, text, category, authorId } }"
}
