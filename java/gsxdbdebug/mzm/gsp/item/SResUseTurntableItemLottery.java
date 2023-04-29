/*    */ package mzm.gsp.item;
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
/*    */ public class SResUseTurntableItemLottery
/*    */   extends __SResUseTurntableItemLottery__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584783;
/*    */   public int lotteryitemid;
/*    */   public ArrayList<Integer> itemids;
/*    */   public int finalindex;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584783;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SResUseTurntableItemLottery()
/*    */   {
/* 33 */     this.itemids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SResUseTurntableItemLottery(int _lotteryitemid_, ArrayList<Integer> _itemids_, int _finalindex_) {
/* 37 */     this.lotteryitemid = _lotteryitemid_;
/* 38 */     this.itemids = _itemids_;
/* 39 */     this.finalindex = _finalindex_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.lotteryitemid);
/* 48 */     _os_.compact_uint32(this.itemids.size());
/* 49 */     for (Integer _v_ : this.itemids) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     _os_.marshal(this.finalindex);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.lotteryitemid = _os_.unmarshal_int();
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 60 */       int _v_ = _os_.unmarshal_int();
/* 61 */       this.itemids.add(Integer.valueOf(_v_));
/*    */     }
/* 63 */     this.finalindex = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SResUseTurntableItemLottery)) {
/* 73 */       SResUseTurntableItemLottery _o_ = (SResUseTurntableItemLottery)_o1_;
/* 74 */       if (this.lotteryitemid != _o_.lotteryitemid) return false;
/* 75 */       if (!this.itemids.equals(_o_.itemids)) return false;
/* 76 */       if (this.finalindex != _o_.finalindex) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.lotteryitemid;
/* 85 */     _h_ += this.itemids.hashCode();
/* 86 */     _h_ += this.finalindex;
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.lotteryitemid).append(",");
/* 94 */     _sb_.append(this.itemids).append(",");
/* 95 */     _sb_.append(this.finalindex).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SResUseTurntableItemLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */