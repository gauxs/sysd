package restaurantmanagement

type PaymentMethod int

const (
	PaymentMethodInvalid = iota
	PaymentMethodUPI
	PaymentMethodCard
)

type Transaction struct {
	ID string
}
