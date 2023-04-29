/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SResUseNormalLottery
/*    */   extends __SResUseNormalLottery__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584781;
/*    */   public int lotteryitemid;
/*    */   public HashMap<Integer, Integer> finalitemid2num;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584781;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SResUseNormalLottery()
/*    */   {
/* 32 */     this.finalitemid2num = new HashMap();
/*    */   }
/*    */   
/*    */   public SResUseNormalLottery(int _lotteryitemid_, HashMap<Integer, Integer> _finalitemid2num_) {
/* 36 */     this.lotteryitemid = _lotteryitemid_;
/* 37 */     this.finalitemid2num = _finalitemid2num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.lotteryitemid);
/* 46 */     _os_.compact_uint32(this.finalitemid2num.size());
/* 47 */     for (Map.Entry<Integer, Integer> _e_ : this.finalitemid2num.entrySet()) {
/* 48 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 49 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.lotteryitemid = _os_.unmarshal_int();
/* 56 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 58 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 60 */       int _v_ = _os_.unmarshal_int();
/* 61 */       this.finalitemid2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 63 */     if (!_validator_()) {
/* 64 */       throw new VerifyError("validator failed");
/*    */     }
/* 66 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 70 */     if (_o1_ == this) return true;
/* 71 */     if ((_o1_ instanceof SResUseNormalLottery)) {
/* 72 */       SResUseNormalLottery _o_ = (SResUseNormalLottery)_o1_;
/* 73 */       if (this.lotteryitemid != _o_.lotteryitemid) return false;
/* 74 */       if (!this.finalitemid2num.equals(_o_.finalitemid2num)) return false;
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     _h_ += this.lotteryitemid;
/* 83 */     _h_ += this.finalitemid2num.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.lotteryitemid).append(",");
/* 91 */     _sb_.append(this.finalitemid2num).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SResUseNormalLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */