import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css']
})
export class PaginationComponent {
  @Input() currentPage: number=0;
  @Input() totalPages: number=0;
  @Output() pageChange = new EventEmitter<number>();

  get pagesArray(): number[] {
    return Array.from({ length: this.totalPages }, (_, index) => index);
  }

  onPageChange(pageNumber: number): void {
    this.pageChange.emit(pageNumber);
  }

}
