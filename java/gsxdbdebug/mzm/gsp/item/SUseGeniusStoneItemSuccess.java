/*    */ package mzm.gsp.item;
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
/*    */ 
/*    */ public class SUseGeniusStoneItemSuccess
/*    */   extends __SUseGeniusStoneItemSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584869;
/*    */   public int item_cfgid;
/*    */   public int used_num;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584869;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUseGeniusStoneItemSuccess() {}
/*    */   
/*    */ 
/*    */   public SUseGeniusStoneItemSuccess(int _item_cfgid_, int _used_num_)
/*    */   {
/* 37 */     this.item_cfgid = _item_cfgid_;
/* 38 */     this.used_num = _used_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.item_cfgid);
/* 47 */     _os_.marshal(this.used_num);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.item_cfgid = _os_.unmarshal_int();
/* 53 */     this.used_num = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SUseGeniusStoneItemSuccess)) {
/* 63 */       SUseGeniusStoneItemSuccess _o_ = (SUseGeniusStoneItemSuccess)_o1_;
/* 64 */       if (this.item_cfgid != _o_.item_cfgid) return false;
/* 65 */       if (this.used_num != _o_.used_num) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.item_cfgid;
/* 74 */     _h_ += this.used_num;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.item_cfgid).append(",");
/* 82 */     _sb_.append(this.used_num).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SUseGeniusStoneItemSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.item_cfgid - _o_.item_cfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.used_num - _o_.used_num;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUseGeniusStoneItemSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */