import { Component, OnInit } from '@angular/core';

import { CartService } from '../service/cart.service';

import { LoginService } from '../service/login.service';
import { Cart } from '../Model/Cart';
import { NotificationService } from '../service/notification.service';
import { NotificationDialogComponent } from '../notification-dialog/notification-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-cart',

  templateUrl: './cart.component.html',

  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  CarOtbj!: Cart;

  CartItems!: any;

  cartList!: any;

  constructor(
    private cartService: CartService,
    private logService: LoginService,
    private notifyService:NotificationService,
    private dialog:MatDialog
  ) {
    this.CarOtbj = new Cart();

    this.CartItems = [];

    this.cartList = [];
  }

  ngOnInit(): void {
    this.cartService.getCartItemByUserId(this.logService.getUserId()).subscribe(
      (res: any) =>   {
        this.CartItems = res;
      },

      (err: any) => console.log(err)
    );
  }
  buy() {}

  delete(cartId: number) {
    this.cartService.deleteCartItemById(cartId).subscribe(
      (res: any) => {
        console.log(res);
        // this.notifyService.showSuccess("", "Item deleted from Cart Successfully");
        const dialogRef = this.dialog.open(NotificationDialogComponent, {
          width: '400px',
          data: {
            title: 'Deleting',
            message: 'Do you really want to delete this item from Cart?'
          }
        });
        dialogRef.afterClosed().subscribe((result: string) => {
          if (result === 'ok') {
            this.notifyService.showSuccess("", "Item deleted from Cart Successfully");
            this.ngOnInit();
          } else if (result === 'cancel') {
            
          }
        })

        
      },

      (err: any) => console.log(err)
    );
  }
}
