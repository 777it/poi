select
  username
from
  user_t
where
  username = /* username */'poi' and
  deleted_at is null