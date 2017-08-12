select
	id
   ,title
   ,body
   ,category
   ,level
   ,updated_at
from
    article_t
where
  username = /* username */'poi' and
  category = /* category */'poi' and
  level = /* level */'poi' and
  deleted_at is null