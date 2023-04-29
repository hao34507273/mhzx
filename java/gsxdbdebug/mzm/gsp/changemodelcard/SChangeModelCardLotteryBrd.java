/*    */ package mzm.gsp.changemodelcard;
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
/*    */ public class SChangeModelCardLotteryBrd
/*    */   extends __SChangeModelCardLotteryBrd__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624419;
/*    */   public String role_name;
/*    */   public int item_cfg_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12624419;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChangeModelCardLotteryBrd()
/*    */   {
/* 34 */     this.role_name = "";
/*    */   }
/*    */   
/*    */   public SChangeModelCardLotteryBrd(String _role_name_, int _item_cfg_id_) {
/* 38 */     this.role_name = _role_name_;
/* 39 */     this.item_cfg_id = _item_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.role_name, "UTF-16LE");
/* 48 */     _os_.marshal(this.item_cfg_id);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.role_name = _os_.unmarshal_String("UTF-16LE");
/* 54 */     this.item_cfg_id = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SChangeModelCardLotteryBrd)) {
/* 64 */       SChangeModelCardLotteryBrd _o_ = (SChangeModelCardLotteryBrd)_o1_;
/* 65 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 66 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.role_name.hashCode();
/* 75 */     _h_ += this.item_cfg_id;
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append("T").append(this.role_name.length()).append(",");
/* 83 */     _sb_.append(this.item_cfg_id).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\SChangeModelCardLotteryBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */