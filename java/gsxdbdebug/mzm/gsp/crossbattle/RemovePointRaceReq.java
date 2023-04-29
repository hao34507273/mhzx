/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class RemovePointRaceReq implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<Long> corpsids;
/*    */   public int fight_num;
/*    */   
/*    */   public RemovePointRaceReq()
/*    */   {
/* 13 */     this.corpsids = new ArrayList();
/*    */   }
/*    */   
/*    */   public RemovePointRaceReq(ArrayList<Long> _corpsids_, int _fight_num_) {
/* 17 */     this.corpsids = _corpsids_;
/* 18 */     this.fight_num = _fight_num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.corpsids.size());
/* 27 */     for (Long _v_ : this.corpsids) {
/* 28 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 30 */     _os_.marshal(this.fight_num);
/* 31 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 35 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 37 */       long _v_ = _os_.unmarshal_long();
/* 38 */       this.corpsids.add(Long.valueOf(_v_));
/*    */     }
/* 40 */     this.fight_num = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof RemovePointRaceReq)) {
/* 47 */       RemovePointRaceReq _o_ = (RemovePointRaceReq)_o1_;
/* 48 */       if (!this.corpsids.equals(_o_.corpsids)) return false;
/* 49 */       if (this.fight_num != _o_.fight_num) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.corpsids.hashCode();
/* 58 */     _h_ += this.fight_num;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.corpsids).append(",");
/* 66 */     _sb_.append(this.fight_num).append(",");
/* 67 */     _sb_.append(")");
/* 68 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\RemovePointRaceReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */