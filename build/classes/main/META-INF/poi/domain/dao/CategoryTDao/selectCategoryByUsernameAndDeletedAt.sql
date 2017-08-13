select
    category
from
    category_t
where
  username = /* username */'poi' and
  deleted_at is null