/*    */ package mzm.gsp.superequipment;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.item.ItemInfo;
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
/*    */ public class SImproveSuperEquipmentStageSuccess
/*    */   extends __SImproveSuperEquipmentStageSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618757;
/*    */   public int improved;
/*    */   public ItemInfo item_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618757;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SImproveSuperEquipmentStageSuccess()
/*    */   {
/* 34 */     this.item_info = new ItemInfo();
/*    */   }
/*    */   
/*    */   public SImproveSuperEquipmentStageSuccess(int _improved_, ItemInfo _item_info_) {
/* 38 */     this.improved = _improved_;
/* 39 */     this.item_info = _item_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.item_info._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.improved);
/* 49 */     _os_.marshal(this.item_info);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.improved = _os_.unmarshal_int();
/* 55 */     this.item_info.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SImproveSuperEquipmentStageSuccess)) {
/* 65 */       SImproveSuperEquipmentStageSuccess _o_ = (SImproveSuperEquipmentStageSuccess)_o1_;
/* 66 */       if (this.improved != _o_.improved) return false;
/* 67 */       if (!this.item_info.equals(_o_.item_info)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.improved;
/* 76 */     _h_ += this.item_info.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.improved).append(",");
/* 84 */     _sb_.append(this.item_info).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\SImproveSuperEquipmentStageSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */