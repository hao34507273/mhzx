/*    */ package mzm.gsp.petmark;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
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
/*    */ public class SPetMarkLotteryDrawSuccess
/*    */   extends __SPetMarkLotteryDrawSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628508;
/*    */   public int lottery_type;
/*    */   public ArrayList<LotteryPetMarkItemInfo> new_pet_mark_item_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628508;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SPetMarkLotteryDrawSuccess()
/*    */   {
/* 34 */     this.new_pet_mark_item_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SPetMarkLotteryDrawSuccess(int _lottery_type_, ArrayList<LotteryPetMarkItemInfo> _new_pet_mark_item_infos_) {
/* 38 */     this.lottery_type = _lottery_type_;
/* 39 */     this.new_pet_mark_item_infos = _new_pet_mark_item_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (LotteryPetMarkItemInfo _v_ : this.new_pet_mark_item_infos)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.lottery_type);
/* 50 */     _os_.compact_uint32(this.new_pet_mark_item_infos.size());
/* 51 */     for (LotteryPetMarkItemInfo _v_ : this.new_pet_mark_item_infos) {
/* 52 */       _os_.marshal(_v_);
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.lottery_type = _os_.unmarshal_int();
/* 59 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 60 */       LotteryPetMarkItemInfo _v_ = new LotteryPetMarkItemInfo();
/* 61 */       _v_.unmarshal(_os_);
/* 62 */       this.new_pet_mark_item_infos.add(_v_);
/*    */     }
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SPetMarkLotteryDrawSuccess)) {
/* 73 */       SPetMarkLotteryDrawSuccess _o_ = (SPetMarkLotteryDrawSuccess)_o1_;
/* 74 */       if (this.lottery_type != _o_.lottery_type) return false;
/* 75 */       if (!this.new_pet_mark_item_infos.equals(_o_.new_pet_mark_item_infos)) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.lottery_type;
/* 84 */     _h_ += this.new_pet_mark_item_infos.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.lottery_type).append(",");
/* 92 */     _sb_.append(this.new_pet_mark_item_infos).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SPetMarkLotteryDrawSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */