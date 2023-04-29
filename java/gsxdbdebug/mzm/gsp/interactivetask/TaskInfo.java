/*    */ package mzm.gsp.interactivetask;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class TaskInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<Integer> finishedgraphs;
/*    */   public int currentgraph;
/*    */   public int iscommander;
/*    */   public long endtime;
/*    */   
/*    */   public TaskInfo()
/*    */   {
/* 15 */     this.finishedgraphs = new ArrayList();
/*    */   }
/*    */   
/*    */   public TaskInfo(ArrayList<Integer> _finishedgraphs_, int _currentgraph_, int _iscommander_, long _endtime_) {
/* 19 */     this.finishedgraphs = _finishedgraphs_;
/* 20 */     this.currentgraph = _currentgraph_;
/* 21 */     this.iscommander = _iscommander_;
/* 22 */     this.endtime = _endtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.compact_uint32(this.finishedgraphs.size());
/* 31 */     for (Integer _v_ : this.finishedgraphs) {
/* 32 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 34 */     _os_.marshal(this.currentgraph);
/* 35 */     _os_.marshal(this.iscommander);
/* 36 */     _os_.marshal(this.endtime);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 43 */       int _v_ = _os_.unmarshal_int();
/* 44 */       this.finishedgraphs.add(Integer.valueOf(_v_));
/*    */     }
/* 46 */     this.currentgraph = _os_.unmarshal_int();
/* 47 */     this.iscommander = _os_.unmarshal_int();
/* 48 */     this.endtime = _os_.unmarshal_long();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof TaskInfo)) {
/* 55 */       TaskInfo _o_ = (TaskInfo)_o1_;
/* 56 */       if (!this.finishedgraphs.equals(_o_.finishedgraphs)) return false;
/* 57 */       if (this.currentgraph != _o_.currentgraph) return false;
/* 58 */       if (this.iscommander != _o_.iscommander) return false;
/* 59 */       if (this.endtime != _o_.endtime) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.finishedgraphs.hashCode();
/* 68 */     _h_ += this.currentgraph;
/* 69 */     _h_ += this.iscommander;
/* 70 */     _h_ += (int)this.endtime;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.finishedgraphs).append(",");
/* 78 */     _sb_.append(this.currentgraph).append(",");
/* 79 */     _sb_.append(this.iscommander).append(",");
/* 80 */     _sb_.append(this.endtime).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\interactivetask\TaskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */