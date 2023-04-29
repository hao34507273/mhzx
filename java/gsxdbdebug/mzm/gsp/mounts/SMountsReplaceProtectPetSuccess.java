/*    */ package mzm.gsp.mounts;
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
/*    */ public class SMountsReplaceProtectPetSuccess
/*    */   extends __SMountsReplaceProtectPetSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12606246;
/*    */   public int cell_id;
/*    */   public int protect_index;
/*    */   public BattleMountsInfo battle_mounts_info;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12606246;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMountsReplaceProtectPetSuccess()
/*    */   {
/* 35 */     this.battle_mounts_info = new BattleMountsInfo();
/*    */   }
/*    */   
/*    */   public SMountsReplaceProtectPetSuccess(int _cell_id_, int _protect_index_, BattleMountsInfo _battle_mounts_info_) {
/* 39 */     this.cell_id = _cell_id_;
/* 40 */     this.protect_index = _protect_index_;
/* 41 */     this.battle_mounts_info = _battle_mounts_info_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     if (!this.battle_mounts_info._validator_()) return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.cell_id);
/* 51 */     _os_.marshal(this.protect_index);
/* 52 */     _os_.marshal(this.battle_mounts_info);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.cell_id = _os_.unmarshal_int();
/* 58 */     this.protect_index = _os_.unmarshal_int();
/* 59 */     this.battle_mounts_info.unmarshal(_os_);
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SMountsReplaceProtectPetSuccess)) {
/* 69 */       SMountsReplaceProtectPetSuccess _o_ = (SMountsReplaceProtectPetSuccess)_o1_;
/* 70 */       if (this.cell_id != _o_.cell_id) return false;
/* 71 */       if (this.protect_index != _o_.protect_index) return false;
/* 72 */       if (!this.battle_mounts_info.equals(_o_.battle_mounts_info)) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.cell_id;
/* 81 */     _h_ += this.protect_index;
/* 82 */     _h_ += this.battle_mounts_info.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.cell_id).append(",");
/* 90 */     _sb_.append(this.protect_index).append(",");
/* 91 */     _sb_.append(this.battle_mounts_info).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SMountsReplaceProtectPetSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */