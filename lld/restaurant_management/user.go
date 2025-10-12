package restaurantmanagement

type Role int

const (
	INVALIDROLE Role = iota
	MANAGER
	WAITER
	CHEF
	CUSTOMER
)

type User struct {
	ID    string
	Roles []Role
}
