/*    */ package mzm.gsp.crossbattle;
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
/*    */ public class SUpdateCrossBattleSelectionProcessInfo
/*    */   extends __SUpdateCrossBattleSelectionProcessInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616992;
/*    */   public int fight_type;
/*    */   public ArrayList<CrossBattleSelectionProcessInfo> process_infos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12616992;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SUpdateCrossBattleSelectionProcessInfo()
/*    */   {
/* 32 */     this.process_infos = new ArrayList();
/*    */   }
/*    */   
/*    */   public SUpdateCrossBattleSelectionProcessInfo(int _fight_type_, ArrayList<CrossBattleSelectionProcessInfo> _process_infos_) {
/* 36 */     this.fight_type = _fight_type_;
/* 37 */     this.process_infos = _process_infos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     for (CrossBattleSelectionProcessInfo _v_ : this.process_infos)
/* 42 */       if (!_v_._validator_()) return false;
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.fight_type);
/* 48 */     _os_.compact_uint32(this.process_infos.size());
/* 49 */     for (CrossBattleSelectionProcessInfo _v_ : this.process_infos) {
/* 50 */       _os_.marshal(_v_);
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.fight_type = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 58 */       CrossBattleSelectionProcessInfo _v_ = new CrossBattleSelectionProcessInfo();
/* 59 */       _v_.unmarshal(_os_);
/* 60 */       this.process_infos.add(_v_);
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SUpdateCrossBattleSelectionProcessInfo)) {
/* 71 */       SUpdateCrossBattleSelectionProcessInfo _o_ = (SUpdateCrossBattleSelectionProcessInfo)_o1_;
/* 72 */       if (this.fight_type != _o_.fight_type) return false;
/* 73 */       if (!this.process_infos.equals(_o_.process_infos)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.fight_type;
/* 82 */     _h_ += this.process_infos.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.fight_type).append(",");
/* 90 */     _sb_.append(this.process_infos).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SUpdateCrossBattleSelectionProcessInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */