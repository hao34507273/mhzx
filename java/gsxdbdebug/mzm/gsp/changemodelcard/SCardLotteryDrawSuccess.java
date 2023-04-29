/*    */ package mzm.gsp.changemodelcard;
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
/*    */ 
/*    */ public class SCardLotteryDrawSuccess
/*    */   extends __SCardLotteryDrawSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12624391;
/*    */   public ArrayList<CardItemInfo> new_card_item_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12624391;
/*    */   }
/*    */   
/*    */ 
/*    */   public SCardLotteryDrawSuccess()
/*    */   {
/* 33 */     this.new_card_item_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SCardLotteryDrawSuccess(ArrayList<CardItemInfo> _new_card_item_infos_) {
/* 37 */     this.new_card_item_infos = _new_card_item_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (CardItemInfo _v_ : this.new_card_item_infos)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.compact_uint32(this.new_card_item_infos.size());
/* 48 */     for (CardItemInfo _v_ : this.new_card_item_infos) {
/* 49 */       _os_.marshal(_v_);
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 56 */       CardItemInfo _v_ = new CardItemInfo();
/* 57 */       _v_.unmarshal(_os_);
/* 58 */       this.new_card_item_infos.add(_v_);
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SCardLotteryDrawSuccess)) {
/* 69 */       SCardLotteryDrawSuccess _o_ = (SCardLotteryDrawSuccess)_o1_;
/* 70 */       if (!this.new_card_item_infos.equals(_o_.new_card_item_infos)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.new_card_item_infos.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.new_card_item_infos).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\changemodelcard\SCardLotteryDrawSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */