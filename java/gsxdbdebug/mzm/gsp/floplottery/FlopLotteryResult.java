/*    */ package mzm.gsp.floplottery;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class FlopLotteryResult implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int index;
/*    */   public ArrayList<RewardItem> awardidlist;
/*    */   
/*    */   public FlopLotteryResult()
/*    */   {
/* 13 */     this.awardidlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public FlopLotteryResult(int _index_, ArrayList<RewardItem> _awardidlist_) {
/* 17 */     this.index = _index_;
/* 18 */     this.awardidlist = _awardidlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (RewardItem _v_ : this.awardidlist)
/* 23 */       if (!_v_._validator_()) return false;
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.index);
/* 29 */     _os_.compact_uint32(this.awardidlist.size());
/* 30 */     for (RewardItem _v_ : this.awardidlist) {
/* 31 */       _os_.marshal(_v_);
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 37 */     this.index = _os_.unmarshal_int();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 39 */       RewardItem _v_ = new RewardItem();
/* 40 */       _v_.unmarshal(_os_);
/* 41 */       this.awardidlist.add(_v_);
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof FlopLotteryResult)) {
/* 49 */       FlopLotteryResult _o_ = (FlopLotteryResult)_o1_;
/* 50 */       if (this.index != _o_.index) return false;
/* 51 */       if (!this.awardidlist.equals(_o_.awardidlist)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.index;
/* 60 */     _h_ += this.awardidlist.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.index).append(",");
/* 68 */     _sb_.append(this.awardidlist).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\FlopLotteryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */