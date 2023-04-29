/*    */ package mzm.gsp.fight;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class OpSummonMonster
/*    */   implements Marshal
/*    */ {
/*    */   public static final int SAME_TEAM = 0;
/*    */   public static final int NOT_SAME_TEAM = 1;
/*    */   public ArrayList<Integer> monsterids;
/*    */   public ArrayList<Integer> positions;
/*    */   public int level;
/*    */   public int sameteam;
/*    */   
/*    */   public OpSummonMonster()
/*    */   {
/* 20 */     this.monsterids = new ArrayList();
/* 21 */     this.positions = new ArrayList();
/*    */   }
/*    */   
/*    */   public OpSummonMonster(ArrayList<Integer> _monsterids_, ArrayList<Integer> _positions_, int _level_, int _sameteam_) {
/* 25 */     this.monsterids = _monsterids_;
/* 26 */     this.positions = _positions_;
/* 27 */     this.level = _level_;
/* 28 */     this.sameteam = _sameteam_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.compact_uint32(this.monsterids.size());
/* 37 */     for (Integer _v_ : this.monsterids) {
/* 38 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 40 */     _os_.compact_uint32(this.positions.size());
/* 41 */     for (Integer _v_ : this.positions) {
/* 42 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 44 */     _os_.marshal(this.level);
/* 45 */     _os_.marshal(this.sameteam);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 52 */       int _v_ = _os_.unmarshal_int();
/* 53 */       this.monsterids.add(Integer.valueOf(_v_));
/*    */     }
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 57 */       int _v_ = _os_.unmarshal_int();
/* 58 */       this.positions.add(Integer.valueOf(_v_));
/*    */     }
/* 60 */     this.level = _os_.unmarshal_int();
/* 61 */     this.sameteam = _os_.unmarshal_int();
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof OpSummonMonster)) {
/* 68 */       OpSummonMonster _o_ = (OpSummonMonster)_o1_;
/* 69 */       if (!this.monsterids.equals(_o_.monsterids)) return false;
/* 70 */       if (!this.positions.equals(_o_.positions)) return false;
/* 71 */       if (this.level != _o_.level) return false;
/* 72 */       if (this.sameteam != _o_.sameteam) return false;
/* 73 */       return true;
/*    */     }
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 79 */     int _h_ = 0;
/* 80 */     _h_ += this.monsterids.hashCode();
/* 81 */     _h_ += this.positions.hashCode();
/* 82 */     _h_ += this.level;
/* 83 */     _h_ += this.sameteam;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.monsterids).append(",");
/* 91 */     _sb_.append(this.positions).append(",");
/* 92 */     _sb_.append(this.level).append(",");
/* 93 */     _sb_.append(this.sameteam).append(",");
/* 94 */     _sb_.append(")");
/* 95 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\OpSummonMonster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */