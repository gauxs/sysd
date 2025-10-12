package restaurantmanagement

import "context"

type Restaurant struct {
	ID   string
	Name string
	Menu *Menu
}

// ctx will have identity of client placing the order
func (r Restaurant) CreateOrder(ctx context.Context, itemIDs []string) {

}

func (r Restaurant) AddItemsToOrder(ctx context.Context, orderID string, itemIDs []string) {

}

func (r Restaurant) RemoveItemsFromOrder(ctx context.Context, orderID string, itemIDs []string) {

}

func (r Restaurant) CancelOrder(ctx context.Context, orderID string) {

}

func (r Restaurant) CompleteOrder(ctx context.Context, orderID string) {
	// change state
	// create bill
}
