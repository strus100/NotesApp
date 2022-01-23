import { TestBed } from '@angular/core/testing';

import { BasicAuth.InterceptorInterceptor } from './basic-auth.interceptor.interceptor';

describe('BasicAuth.InterceptorInterceptor', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [
      BasicAuth.InterceptorInterceptor
      ]
  }));

  it('should be created', () => {
    const interceptor: BasicAuth.InterceptorInterceptor = TestBed.inject(BasicAuth.InterceptorInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
