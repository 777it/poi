update 
  category_t
set 
  category = /* entity.category */'poi'
 ,updated_at = now()
where 
  id = /* id */'poi'
