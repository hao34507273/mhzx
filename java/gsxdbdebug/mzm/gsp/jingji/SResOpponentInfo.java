/*    */ package mzm.gsp.jingji;
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
/*    */ public class SResOpponentInfo
/*    */   extends __SResOpponentInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12595713;
/*    */   public ArrayList<OpponentInfo> opponentlist;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12595713;
/*    */   }
/*    */   
/*    */ 
/*    */   public SResOpponentInfo()
/*    */   {
/* 31 */     this.opponentlist = new ArrayList();
/*    */   }
/*    */   
/*    */   public SResOpponentInfo(ArrayList<OpponentInfo> _opponentlist_) {
/* 35 */     this.opponentlist = _opponentlist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 39 */     for (OpponentInfo _v_ : this.opponentlist)
/* 40 */       if (!_v_._validator_()) return false;
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.compact_uint32(this.opponentlist.size());
/* 46 */     for (OpponentInfo _v_ : this.opponentlist) {
/* 47 */       _os_.marshal(_v_);
/*    */     }
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 54 */       OpponentInfo _v_ = new OpponentInfo();
/* 55 */       _v_.unmarshal(_os_);
/* 56 */       this.opponentlist.add(_v_);
/*    */     }
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SResOpponentInfo)) {
/* 67 */       SResOpponentInfo _o_ = (SResOpponentInfo)_o1_;
/* 68 */       if (!this.opponentlist.equals(_o_.opponentlist)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.opponentlist.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.opponentlist).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\SResOpponentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */