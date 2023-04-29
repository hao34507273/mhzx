/*    */ package mzm.gsp.petarena;
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
/*    */ public class SyncOpponentInfos
/*    */   extends __SyncOpponentInfos__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628235;
/*    */   public ArrayList<OpponentInfo> opponent_infos;
/*    */   public int serial;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628235;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SyncOpponentInfos()
/*    */   {
/* 34 */     this.opponent_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SyncOpponentInfos(ArrayList<OpponentInfo> _opponent_infos_, int _serial_) {
/* 38 */     this.opponent_infos = _opponent_infos_;
/* 39 */     this.serial = _serial_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (OpponentInfo _v_ : this.opponent_infos)
/* 44 */       if (!_v_._validator_()) return false;
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.compact_uint32(this.opponent_infos.size());
/* 50 */     for (OpponentInfo _v_ : this.opponent_infos) {
/* 51 */       _os_.marshal(_v_);
/*    */     }
/* 53 */     _os_.marshal(this.serial);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 59 */       OpponentInfo _v_ = new OpponentInfo();
/* 60 */       _v_.unmarshal(_os_);
/* 61 */       this.opponent_infos.add(_v_);
/*    */     }
/* 63 */     this.serial = _os_.unmarshal_int();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof SyncOpponentInfos)) {
/* 73 */       SyncOpponentInfos _o_ = (SyncOpponentInfos)_o1_;
/* 74 */       if (!this.opponent_infos.equals(_o_.opponent_infos)) return false;
/* 75 */       if (this.serial != _o_.serial) return false;
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 82 */     int _h_ = 0;
/* 83 */     _h_ += this.opponent_infos.hashCode();
/* 84 */     _h_ += this.serial;
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.opponent_infos).append(",");
/* 92 */     _sb_.append(this.serial).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SyncOpponentInfos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */