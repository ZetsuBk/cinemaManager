import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'groupArray',
  standalone:true
})
export class GroupArrayPipe implements PipeTransform {
  transform(value: any[], groupSize: number): any[] {
    const groupedArray = [];

    for (let i = 0; i < value.length; i += groupSize) {
      groupedArray.push(value.slice(i, i + groupSize));
    }

    return groupedArray;
  }
}
