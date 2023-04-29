/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SEnterFightOperFighters
/*    */   extends __SEnterFightOperFighters__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594211;
/*    */   public long fight_uuid;
/*    */   public int round;
/*    */   public HashSet<Integer> operuuids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594211;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SEnterFightOperFighters()
/*    */   {
/* 35 */     this.operuuids = new HashSet();
/*    */   }
/*    */   
/*    */   public SEnterFightOperFighters(long _fight_uuid_, int _round_, HashSet<Integer> _operuuids_) {
/* 39 */     this.fight_uuid = _fight_uuid_;
/* 40 */     this.round = _round_;
/* 41 */     this.operuuids = _operuuids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.fight_uuid);
/* 50 */     _os_.marshal(this.round);
/* 51 */     _os_.compact_uint32(this.operuuids.size());
/* 52 */     for (Integer _v_ : this.operuuids) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.fight_uuid = _os_.unmarshal_long();
/* 60 */     this.round = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.operuuids.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SEnterFightOperFighters)) {
/* 75 */       SEnterFightOperFighters _o_ = (SEnterFightOperFighters)_o1_;
/* 76 */       if (this.fight_uuid != _o_.fight_uuid) return false;
/* 77 */       if (this.round != _o_.round) return false;
/* 78 */       if (!this.operuuids.equals(_o_.operuuids)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += (int)this.fight_uuid;
/* 87 */     _h_ += this.round;
/* 88 */     _h_ += this.operuuids.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.fight_uuid).append(",");
/* 96 */     _sb_.append(this.round).append(",");
/* 97 */     _sb_.append(this.operuuids).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SEnterFightOperFighters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */