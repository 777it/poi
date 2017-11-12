update 
  article_t
set 
  title = /* entity.title */'poi'
 ,body = /* entity.body */'poi'
 ,category = /* entity.category */'poi'
 ,level = /* entity.level */1
 ,updated_at = now()
where 
  id = /* id */'poi'
