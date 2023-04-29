/*    */ package mzm.gsp.cat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SQueryCatsSuccess
/*    */   extends __SQueryCatsSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12605700;
/*    */   public long target_roleid;
/*    */   public CatInfo cat_info;
/*    */   public int feed_num;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12605700;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SQueryCatsSuccess()
/*    */   {
/* 35 */     this.cat_info = new CatInfo();
/*    */   }
/*    */   
/*    */   public SQueryCatsSuccess(long _target_roleid_, CatInfo _cat_info_, int _feed_num_) {
/* 39 */     this.target_roleid = _target_roleid_;
/* 40 */     this.cat_info = _cat_info_;
/* 41 */     this.feed_num = _feed_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.cat_info._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.target_roleid);
/* 51 */     _os_.marshal(this.cat_info);
/* 52 */     _os_.marshal(this.feed_num);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.target_roleid = _os_.unmarshal_long();
/* 58 */     this.cat_info.unmarshal(_os_);
/* 59 */     this.feed_num = _os_.unmarshal_int();
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SQueryCatsSuccess)) {
/* 69 */       SQueryCatsSuccess _o_ = (SQueryCatsSuccess)_o1_;
/* 70 */       if (this.target_roleid != _o_.target_roleid) return false;
/* 71 */       if (!this.cat_info.equals(_o_.cat_info)) return false;
/* 72 */       if (this.feed_num != _o_.feed_num) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += (int)this.target_roleid;
/* 81 */     _h_ += this.cat_info.hashCode();
/* 82 */     _h_ += this.feed_num;
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.target_roleid).append(",");
/* 90 */     _sb_.append(this.cat_info).append(",");
/* 91 */     _sb_.append(this.feed_num).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cat\SQueryCatsSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */