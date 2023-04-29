/*    */ package mzm.gsp.constellation;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class ConstellationCards implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int constellation;
/*    */   public ArrayList<Integer> stars;
/*    */   public int fortune;
/*    */   
/*    */   public ConstellationCards()
/*    */   {
/* 14 */     this.stars = new ArrayList();
/*    */   }
/*    */   
/*    */   public ConstellationCards(int _constellation_, ArrayList<Integer> _stars_, int _fortune_) {
/* 18 */     this.constellation = _constellation_;
/* 19 */     this.stars = _stars_;
/* 20 */     this.fortune = _fortune_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.constellation);
/* 29 */     _os_.compact_uint32(this.stars.size());
/* 30 */     for (Integer _v_ : this.stars) {
/* 31 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 33 */     _os_.marshal(this.fortune);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 38 */     this.constellation = _os_.unmarshal_int();
/* 39 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 41 */       int _v_ = _os_.unmarshal_int();
/* 42 */       this.stars.add(Integer.valueOf(_v_));
/*    */     }
/* 44 */     this.fortune = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof ConstellationCards)) {
/* 51 */       ConstellationCards _o_ = (ConstellationCards)_o1_;
/* 52 */       if (this.constellation != _o_.constellation) return false;
/* 53 */       if (!this.stars.equals(_o_.stars)) return false;
/* 54 */       if (this.fortune != _o_.fortune) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += this.constellation;
/* 63 */     _h_ += this.stars.hashCode();
/* 64 */     _h_ += this.fortune;
/* 65 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuilder _sb_ = new StringBuilder();
/* 70 */     _sb_.append("(");
/* 71 */     _sb_.append(this.constellation).append(",");
/* 72 */     _sb_.append(this.stars).append(",");
/* 73 */     _sb_.append(this.fortune).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\ConstellationCards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */