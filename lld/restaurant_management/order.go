package restaurantmanagement

import (
	"github.com/google/uuid"
)

type OrderStatus int

const (
	OrderStatusInvalid OrderStatus = iota
	// Order is created and items can be ordered now
	OrderStatusCreated
	// Items are being currently ordered
	OrderStatusOngoing
	// New items cannot be added to this order
	OrderStatusCompleted
	OrderStatusPaymentNotDone
	OrderStatusPaymentDone
	OrderStatusCancelled
)

type ItemStatus int

const (
	ItemStatusInvalid ItemStatus = iota
)

type OrderedItem struct {
	ItemID     string
	Quantity   string
	ItemStatus ItemStatus
}

type Order struct {
	ID           string
	Status       OrderStatus
	OrderedItems []OrderedItem
	Billing      Billing
}

func NewOrder() *Order {
	orderId := uuid.New()
	return &Order{
		ID:     orderId.String(),
		Status: OrderStatusCreated,
	}
}
