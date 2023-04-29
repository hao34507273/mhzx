/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class ChildhoodInfo extends XBean implements xbean.ChildhoodInfo
/*      */ {
/*      */   private int interest;
/*      */   private HashMap<Integer, xbean.CourseInfo> courses;
/*      */   private xbean.CourseStudyInfo cur_course;
/*      */   private xbean.DailyCourseInfo daily_curse;
/*      */   private int total_num;
/*      */   private int total_crit_num;
/*      */   private int child_hood_model_cfg_id;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.interest = 0;
/*   31 */     this.courses.clear();
/*   32 */     this.cur_course._reset_unsafe_();
/*   33 */     this.daily_curse._reset_unsafe_();
/*   34 */     this.total_num = 0;
/*   35 */     this.total_crit_num = 0;
/*   36 */     this.child_hood_model_cfg_id = 0;
/*      */   }
/*      */   
/*      */   ChildhoodInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.courses = new HashMap();
/*   43 */     this.cur_course = new CourseStudyInfo(0, this, "cur_course");
/*   44 */     this.daily_curse = new DailyCourseInfo(0, this, "daily_curse");
/*      */   }
/*      */   
/*      */   public ChildhoodInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ChildhoodInfo(ChildhoodInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ChildhoodInfo(xbean.ChildhoodInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof ChildhoodInfo)) { assign((ChildhoodInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ChildhoodInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.interest = _o_.interest;
/*   70 */     this.courses = new HashMap();
/*   71 */     for (Map.Entry<Integer, xbean.CourseInfo> _e_ : _o_.courses.entrySet())
/*   72 */       this.courses.put(_e_.getKey(), new CourseInfo((xbean.CourseInfo)_e_.getValue(), this, "courses"));
/*   73 */     this.cur_course = new CourseStudyInfo(_o_.cur_course, this, "cur_course");
/*   74 */     this.daily_curse = new DailyCourseInfo(_o_.daily_curse, this, "daily_curse");
/*   75 */     this.total_num = _o_.total_num;
/*   76 */     this.total_crit_num = _o_.total_crit_num;
/*   77 */     this.child_hood_model_cfg_id = _o_.child_hood_model_cfg_id;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   82 */     this.interest = _o_.interest;
/*   83 */     this.courses = new HashMap();
/*   84 */     for (Map.Entry<Integer, xbean.CourseInfo> _e_ : _o_.courses.entrySet())
/*   85 */       this.courses.put(_e_.getKey(), new CourseInfo((xbean.CourseInfo)_e_.getValue(), this, "courses"));
/*   86 */     this.cur_course = new CourseStudyInfo(_o_.cur_course, this, "cur_course");
/*   87 */     this.daily_curse = new DailyCourseInfo(_o_.daily_curse, this, "daily_curse");
/*   88 */     this.total_num = _o_.total_num;
/*   89 */     this.total_crit_num = _o_.total_crit_num;
/*   90 */     this.child_hood_model_cfg_id = _o_.child_hood_model_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   96 */     _xdb_verify_unsafe_();
/*   97 */     _os_.marshal(this.interest);
/*   98 */     _os_.compact_uint32(this.courses.size());
/*   99 */     for (Map.Entry<Integer, xbean.CourseInfo> _e_ : this.courses.entrySet())
/*      */     {
/*  101 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  102 */       ((xbean.CourseInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  104 */     this.cur_course.marshal(_os_);
/*  105 */     this.daily_curse.marshal(_os_);
/*  106 */     _os_.marshal(this.total_num);
/*  107 */     _os_.marshal(this.total_crit_num);
/*  108 */     _os_.marshal(this.child_hood_model_cfg_id);
/*  109 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  115 */     _xdb_verify_unsafe_();
/*  116 */     this.interest = _os_.unmarshal_int();
/*      */     
/*  118 */     int size = _os_.uncompact_uint32();
/*  119 */     if (size >= 12)
/*      */     {
/*  121 */       this.courses = new HashMap(size * 2);
/*      */     }
/*  123 */     for (; size > 0; size--)
/*      */     {
/*  125 */       int _k_ = 0;
/*  126 */       _k_ = _os_.unmarshal_int();
/*  127 */       xbean.CourseInfo _v_ = new CourseInfo(0, this, "courses");
/*  128 */       _v_.unmarshal(_os_);
/*  129 */       this.courses.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  132 */     this.cur_course.unmarshal(_os_);
/*  133 */     this.daily_curse.unmarshal(_os_);
/*  134 */     this.total_num = _os_.unmarshal_int();
/*  135 */     this.total_crit_num = _os_.unmarshal_int();
/*  136 */     this.child_hood_model_cfg_id = _os_.unmarshal_int();
/*  137 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  143 */     _xdb_verify_unsafe_();
/*  144 */     int _size_ = 0;
/*  145 */     _size_ += CodedOutputStream.computeInt32Size(1, this.interest);
/*  146 */     for (Map.Entry<Integer, xbean.CourseInfo> _e_ : this.courses.entrySet())
/*      */     {
/*  148 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  149 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  151 */     _size_ += CodedOutputStream.computeMessageSize(3, this.cur_course);
/*  152 */     _size_ += CodedOutputStream.computeMessageSize(4, this.daily_curse);
/*  153 */     _size_ += CodedOutputStream.computeInt32Size(5, this.total_num);
/*  154 */     _size_ += CodedOutputStream.computeInt32Size(6, this.total_crit_num);
/*  155 */     _size_ += CodedOutputStream.computeInt32Size(7, this.child_hood_model_cfg_id);
/*  156 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  162 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  165 */       _output_.writeInt32(1, this.interest);
/*  166 */       for (Map.Entry<Integer, xbean.CourseInfo> _e_ : this.courses.entrySet())
/*      */       {
/*  168 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  169 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  171 */       _output_.writeMessage(3, this.cur_course);
/*  172 */       _output_.writeMessage(4, this.daily_curse);
/*  173 */       _output_.writeInt32(5, this.total_num);
/*  174 */       _output_.writeInt32(6, this.total_crit_num);
/*  175 */       _output_.writeInt32(7, this.child_hood_model_cfg_id);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  181 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  187 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  190 */       boolean done = false;
/*  191 */       while (!done)
/*      */       {
/*  193 */         int tag = _input_.readTag();
/*  194 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  198 */           done = true;
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  203 */           this.interest = _input_.readInt32();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  208 */           int _k_ = 0;
/*  209 */           _k_ = _input_.readInt32();
/*  210 */           int readTag = _input_.readTag();
/*  211 */           if (18 != readTag)
/*      */           {
/*  213 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  215 */           xbean.CourseInfo _v_ = new CourseInfo(0, this, "courses");
/*  216 */           _input_.readMessage(_v_);
/*  217 */           this.courses.put(Integer.valueOf(_k_), _v_);
/*  218 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  222 */           _input_.readMessage(this.cur_course);
/*  223 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  227 */           _input_.readMessage(this.daily_curse);
/*  228 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  232 */           this.total_num = _input_.readInt32();
/*  233 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  237 */           this.total_crit_num = _input_.readInt32();
/*  238 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  242 */           this.child_hood_model_cfg_id = _input_.readInt32();
/*  243 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  247 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  249 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  258 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  262 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  264 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildhoodInfo copy()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return new ChildhoodInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildhoodInfo toData()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChildhoodInfo toBean()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new ChildhoodInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChildhoodInfo toDataIf()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChildhoodInfo toBeanIf()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getInterest()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return this.interest;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.CourseInfo> getCourses()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return xdb.Logs.logMap(new LogKey(this, "courses"), this.courses);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.CourseInfo> getCoursesAsData()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*      */     
/*  329 */     ChildhoodInfo _o_ = this;
/*  330 */     Map<Integer, xbean.CourseInfo> courses = new HashMap();
/*  331 */     for (Map.Entry<Integer, xbean.CourseInfo> _e_ : _o_.courses.entrySet())
/*  332 */       courses.put(_e_.getKey(), new CourseInfo.Data((xbean.CourseInfo)_e_.getValue()));
/*  333 */     return courses;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.CourseStudyInfo getCur_course()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return this.cur_course;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.DailyCourseInfo getDaily_curse()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this.daily_curse;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_num()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return this.total_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_crit_num()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     return this.total_crit_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChild_hood_model_cfg_id()
/*      */   {
/*  372 */     _xdb_verify_unsafe_();
/*  373 */     return this.child_hood_model_cfg_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInterest(int _v_)
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     xdb.Logs.logIf(new LogKey(this, "interest")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  385 */         new LogInt(this, ChildhoodInfo.this.interest)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  389 */             ChildhoodInfo.this.interest = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  393 */     });
/*  394 */     this.interest = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_num(int _v_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     xdb.Logs.logIf(new LogKey(this, "total_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  406 */         new LogInt(this, ChildhoodInfo.this.total_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  410 */             ChildhoodInfo.this.total_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  414 */     });
/*  415 */     this.total_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_crit_num(int _v_)
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     xdb.Logs.logIf(new LogKey(this, "total_crit_num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  427 */         new LogInt(this, ChildhoodInfo.this.total_crit_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  431 */             ChildhoodInfo.this.total_crit_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  435 */     });
/*  436 */     this.total_crit_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChild_hood_model_cfg_id(int _v_)
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     xdb.Logs.logIf(new LogKey(this, "child_hood_model_cfg_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  448 */         new LogInt(this, ChildhoodInfo.this.child_hood_model_cfg_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  452 */             ChildhoodInfo.this.child_hood_model_cfg_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  456 */     });
/*  457 */     this.child_hood_model_cfg_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     ChildhoodInfo _o_ = null;
/*  465 */     if ((_o1_ instanceof ChildhoodInfo)) { _o_ = (ChildhoodInfo)_o1_;
/*  466 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  467 */       return false;
/*  468 */     if (this.interest != _o_.interest) return false;
/*  469 */     if (!this.courses.equals(_o_.courses)) return false;
/*  470 */     if (!this.cur_course.equals(_o_.cur_course)) return false;
/*  471 */     if (!this.daily_curse.equals(_o_.daily_curse)) return false;
/*  472 */     if (this.total_num != _o_.total_num) return false;
/*  473 */     if (this.total_crit_num != _o_.total_crit_num) return false;
/*  474 */     if (this.child_hood_model_cfg_id != _o_.child_hood_model_cfg_id) return false;
/*  475 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  481 */     _xdb_verify_unsafe_();
/*  482 */     int _h_ = 0;
/*  483 */     _h_ += this.interest;
/*  484 */     _h_ += this.courses.hashCode();
/*  485 */     _h_ += this.cur_course.hashCode();
/*  486 */     _h_ += this.daily_curse.hashCode();
/*  487 */     _h_ += this.total_num;
/*  488 */     _h_ += this.total_crit_num;
/*  489 */     _h_ += this.child_hood_model_cfg_id;
/*  490 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     StringBuilder _sb_ = new StringBuilder();
/*  498 */     _sb_.append("(");
/*  499 */     _sb_.append(this.interest);
/*  500 */     _sb_.append(",");
/*  501 */     _sb_.append(this.courses);
/*  502 */     _sb_.append(",");
/*  503 */     _sb_.append(this.cur_course);
/*  504 */     _sb_.append(",");
/*  505 */     _sb_.append(this.daily_curse);
/*  506 */     _sb_.append(",");
/*  507 */     _sb_.append(this.total_num);
/*  508 */     _sb_.append(",");
/*  509 */     _sb_.append(this.total_crit_num);
/*  510 */     _sb_.append(",");
/*  511 */     _sb_.append(this.child_hood_model_cfg_id);
/*  512 */     _sb_.append(")");
/*  513 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  519 */     ListenableBean lb = new ListenableBean();
/*  520 */     lb.add(new ListenableChanged().setVarName("interest"));
/*  521 */     lb.add(new xdb.logs.ListenableMap().setVarName("courses"));
/*  522 */     lb.add(new ListenableChanged().setVarName("cur_course"));
/*  523 */     lb.add(new ListenableChanged().setVarName("daily_curse"));
/*  524 */     lb.add(new ListenableChanged().setVarName("total_num"));
/*  525 */     lb.add(new ListenableChanged().setVarName("total_crit_num"));
/*  526 */     lb.add(new ListenableChanged().setVarName("child_hood_model_cfg_id"));
/*  527 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ChildhoodInfo {
/*      */     private Const() {}
/*      */     
/*      */     ChildhoodInfo nThis() {
/*  534 */       return ChildhoodInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  540 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildhoodInfo copy()
/*      */     {
/*  546 */       return ChildhoodInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildhoodInfo toData()
/*      */     {
/*  552 */       return ChildhoodInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ChildhoodInfo toBean()
/*      */     {
/*  557 */       return ChildhoodInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildhoodInfo toDataIf()
/*      */     {
/*  563 */       return ChildhoodInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ChildhoodInfo toBeanIf()
/*      */     {
/*  568 */       return ChildhoodInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getInterest()
/*      */     {
/*  575 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  576 */       return ChildhoodInfo.this.interest;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CourseInfo> getCourses()
/*      */     {
/*  583 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  584 */       return xdb.Consts.constMap(ChildhoodInfo.this.courses);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CourseInfo> getCoursesAsData()
/*      */     {
/*  591 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*      */       
/*  593 */       ChildhoodInfo _o_ = ChildhoodInfo.this;
/*  594 */       Map<Integer, xbean.CourseInfo> courses = new HashMap();
/*  595 */       for (Map.Entry<Integer, xbean.CourseInfo> _e_ : _o_.courses.entrySet())
/*  596 */         courses.put(_e_.getKey(), new CourseInfo.Data((xbean.CourseInfo)_e_.getValue()));
/*  597 */       return courses;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.CourseStudyInfo getCur_course()
/*      */     {
/*  604 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  605 */       return (xbean.CourseStudyInfo)xdb.Consts.toConst(ChildhoodInfo.this.cur_course);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.DailyCourseInfo getDaily_curse()
/*      */     {
/*  612 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  613 */       return (xbean.DailyCourseInfo)xdb.Consts.toConst(ChildhoodInfo.this.daily_curse);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_num()
/*      */     {
/*  620 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  621 */       return ChildhoodInfo.this.total_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_crit_num()
/*      */     {
/*  628 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  629 */       return ChildhoodInfo.this.total_crit_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChild_hood_model_cfg_id()
/*      */     {
/*  636 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  637 */       return ChildhoodInfo.this.child_hood_model_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInterest(int _v_)
/*      */     {
/*  644 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  645 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_num(int _v_)
/*      */     {
/*  652 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_crit_num(int _v_)
/*      */     {
/*  660 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_hood_model_cfg_id(int _v_)
/*      */     {
/*  668 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  669 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  675 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  676 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  682 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  683 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  689 */       return ChildhoodInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  695 */       return ChildhoodInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  701 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  702 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  708 */       return ChildhoodInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  714 */       return ChildhoodInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  720 */       ChildhoodInfo.this._xdb_verify_unsafe_();
/*  721 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  727 */       return ChildhoodInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  733 */       return ChildhoodInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  739 */       return ChildhoodInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  745 */       return ChildhoodInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  751 */       return ChildhoodInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  757 */       return ChildhoodInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  763 */       return ChildhoodInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ChildhoodInfo
/*      */   {
/*      */     private int interest;
/*      */     
/*      */     private HashMap<Integer, xbean.CourseInfo> courses;
/*      */     
/*      */     private xbean.CourseStudyInfo cur_course;
/*      */     
/*      */     private xbean.DailyCourseInfo daily_curse;
/*      */     
/*      */     private int total_num;
/*      */     
/*      */     private int total_crit_num;
/*      */     
/*      */     private int child_hood_model_cfg_id;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  787 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  792 */       this.courses = new HashMap();
/*  793 */       this.cur_course = new CourseStudyInfo.Data();
/*  794 */       this.daily_curse = new DailyCourseInfo.Data();
/*      */     }
/*      */     
/*      */     Data(xbean.ChildhoodInfo _o1_)
/*      */     {
/*  799 */       if ((_o1_ instanceof ChildhoodInfo)) { assign((ChildhoodInfo)_o1_);
/*  800 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  801 */       } else if ((_o1_ instanceof ChildhoodInfo.Const)) assign(((ChildhoodInfo.Const)_o1_).nThis()); else {
/*  802 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ChildhoodInfo _o_) {
/*  807 */       this.interest = _o_.interest;
/*  808 */       this.courses = new HashMap();
/*  809 */       for (Map.Entry<Integer, xbean.CourseInfo> _e_ : _o_.courses.entrySet())
/*  810 */         this.courses.put(_e_.getKey(), new CourseInfo.Data((xbean.CourseInfo)_e_.getValue()));
/*  811 */       this.cur_course = new CourseStudyInfo.Data(_o_.cur_course);
/*  812 */       this.daily_curse = new DailyCourseInfo.Data(_o_.daily_curse);
/*  813 */       this.total_num = _o_.total_num;
/*  814 */       this.total_crit_num = _o_.total_crit_num;
/*  815 */       this.child_hood_model_cfg_id = _o_.child_hood_model_cfg_id;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  820 */       this.interest = _o_.interest;
/*  821 */       this.courses = new HashMap();
/*  822 */       for (Map.Entry<Integer, xbean.CourseInfo> _e_ : _o_.courses.entrySet())
/*  823 */         this.courses.put(_e_.getKey(), new CourseInfo.Data((xbean.CourseInfo)_e_.getValue()));
/*  824 */       this.cur_course = new CourseStudyInfo.Data(_o_.cur_course);
/*  825 */       this.daily_curse = new DailyCourseInfo.Data(_o_.daily_curse);
/*  826 */       this.total_num = _o_.total_num;
/*  827 */       this.total_crit_num = _o_.total_crit_num;
/*  828 */       this.child_hood_model_cfg_id = _o_.child_hood_model_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  834 */       _os_.marshal(this.interest);
/*  835 */       _os_.compact_uint32(this.courses.size());
/*  836 */       for (Map.Entry<Integer, xbean.CourseInfo> _e_ : this.courses.entrySet())
/*      */       {
/*  838 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  839 */         ((xbean.CourseInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  841 */       this.cur_course.marshal(_os_);
/*  842 */       this.daily_curse.marshal(_os_);
/*  843 */       _os_.marshal(this.total_num);
/*  844 */       _os_.marshal(this.total_crit_num);
/*  845 */       _os_.marshal(this.child_hood_model_cfg_id);
/*  846 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  852 */       this.interest = _os_.unmarshal_int();
/*      */       
/*  854 */       int size = _os_.uncompact_uint32();
/*  855 */       if (size >= 12)
/*      */       {
/*  857 */         this.courses = new HashMap(size * 2);
/*      */       }
/*  859 */       for (; size > 0; size--)
/*      */       {
/*  861 */         int _k_ = 0;
/*  862 */         _k_ = _os_.unmarshal_int();
/*  863 */         xbean.CourseInfo _v_ = xbean.Pod.newCourseInfoData();
/*  864 */         _v_.unmarshal(_os_);
/*  865 */         this.courses.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  868 */       this.cur_course.unmarshal(_os_);
/*  869 */       this.daily_curse.unmarshal(_os_);
/*  870 */       this.total_num = _os_.unmarshal_int();
/*  871 */       this.total_crit_num = _os_.unmarshal_int();
/*  872 */       this.child_hood_model_cfg_id = _os_.unmarshal_int();
/*  873 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  879 */       int _size_ = 0;
/*  880 */       _size_ += CodedOutputStream.computeInt32Size(1, this.interest);
/*  881 */       for (Map.Entry<Integer, xbean.CourseInfo> _e_ : this.courses.entrySet())
/*      */       {
/*  883 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  884 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  886 */       _size_ += CodedOutputStream.computeMessageSize(3, this.cur_course);
/*  887 */       _size_ += CodedOutputStream.computeMessageSize(4, this.daily_curse);
/*  888 */       _size_ += CodedOutputStream.computeInt32Size(5, this.total_num);
/*  889 */       _size_ += CodedOutputStream.computeInt32Size(6, this.total_crit_num);
/*  890 */       _size_ += CodedOutputStream.computeInt32Size(7, this.child_hood_model_cfg_id);
/*  891 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  899 */         _output_.writeInt32(1, this.interest);
/*  900 */         for (Map.Entry<Integer, xbean.CourseInfo> _e_ : this.courses.entrySet())
/*      */         {
/*  902 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  903 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/*  905 */         _output_.writeMessage(3, this.cur_course);
/*  906 */         _output_.writeMessage(4, this.daily_curse);
/*  907 */         _output_.writeInt32(5, this.total_num);
/*  908 */         _output_.writeInt32(6, this.total_crit_num);
/*  909 */         _output_.writeInt32(7, this.child_hood_model_cfg_id);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  913 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  915 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  923 */         boolean done = false;
/*  924 */         while (!done)
/*      */         {
/*  926 */           int tag = _input_.readTag();
/*  927 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  931 */             done = true;
/*  932 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  936 */             this.interest = _input_.readInt32();
/*  937 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  941 */             int _k_ = 0;
/*  942 */             _k_ = _input_.readInt32();
/*  943 */             int readTag = _input_.readTag();
/*  944 */             if (18 != readTag)
/*      */             {
/*  946 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  948 */             xbean.CourseInfo _v_ = xbean.Pod.newCourseInfoData();
/*  949 */             _input_.readMessage(_v_);
/*  950 */             this.courses.put(Integer.valueOf(_k_), _v_);
/*  951 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  955 */             _input_.readMessage(this.cur_course);
/*  956 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/*  960 */             _input_.readMessage(this.daily_curse);
/*  961 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  965 */             this.total_num = _input_.readInt32();
/*  966 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  970 */             this.total_crit_num = _input_.readInt32();
/*  971 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  975 */             this.child_hood_model_cfg_id = _input_.readInt32();
/*  976 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  980 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  982 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  991 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  995 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  997 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildhoodInfo copy()
/*      */     {
/* 1003 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildhoodInfo toData()
/*      */     {
/* 1009 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ChildhoodInfo toBean()
/*      */     {
/* 1014 */       return new ChildhoodInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChildhoodInfo toDataIf()
/*      */     {
/* 1020 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ChildhoodInfo toBeanIf()
/*      */     {
/* 1025 */       return new ChildhoodInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1031 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1035 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1039 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1043 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1047 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1051 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1055 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getInterest()
/*      */     {
/* 1062 */       return this.interest;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CourseInfo> getCourses()
/*      */     {
/* 1069 */       return this.courses;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.CourseInfo> getCoursesAsData()
/*      */     {
/* 1076 */       return this.courses;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.CourseStudyInfo getCur_course()
/*      */     {
/* 1083 */       return this.cur_course;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.DailyCourseInfo getDaily_curse()
/*      */     {
/* 1090 */       return this.daily_curse;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_num()
/*      */     {
/* 1097 */       return this.total_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_crit_num()
/*      */     {
/* 1104 */       return this.total_crit_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChild_hood_model_cfg_id()
/*      */     {
/* 1111 */       return this.child_hood_model_cfg_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInterest(int _v_)
/*      */     {
/* 1118 */       this.interest = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_num(int _v_)
/*      */     {
/* 1125 */       this.total_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_crit_num(int _v_)
/*      */     {
/* 1132 */       this.total_crit_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChild_hood_model_cfg_id(int _v_)
/*      */     {
/* 1139 */       this.child_hood_model_cfg_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1145 */       if (!(_o1_ instanceof Data)) return false;
/* 1146 */       Data _o_ = (Data)_o1_;
/* 1147 */       if (this.interest != _o_.interest) return false;
/* 1148 */       if (!this.courses.equals(_o_.courses)) return false;
/* 1149 */       if (!this.cur_course.equals(_o_.cur_course)) return false;
/* 1150 */       if (!this.daily_curse.equals(_o_.daily_curse)) return false;
/* 1151 */       if (this.total_num != _o_.total_num) return false;
/* 1152 */       if (this.total_crit_num != _o_.total_crit_num) return false;
/* 1153 */       if (this.child_hood_model_cfg_id != _o_.child_hood_model_cfg_id) return false;
/* 1154 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1160 */       int _h_ = 0;
/* 1161 */       _h_ += this.interest;
/* 1162 */       _h_ += this.courses.hashCode();
/* 1163 */       _h_ += this.cur_course.hashCode();
/* 1164 */       _h_ += this.daily_curse.hashCode();
/* 1165 */       _h_ += this.total_num;
/* 1166 */       _h_ += this.total_crit_num;
/* 1167 */       _h_ += this.child_hood_model_cfg_id;
/* 1168 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1174 */       StringBuilder _sb_ = new StringBuilder();
/* 1175 */       _sb_.append("(");
/* 1176 */       _sb_.append(this.interest);
/* 1177 */       _sb_.append(",");
/* 1178 */       _sb_.append(this.courses);
/* 1179 */       _sb_.append(",");
/* 1180 */       _sb_.append(this.cur_course);
/* 1181 */       _sb_.append(",");
/* 1182 */       _sb_.append(this.daily_curse);
/* 1183 */       _sb_.append(",");
/* 1184 */       _sb_.append(this.total_num);
/* 1185 */       _sb_.append(",");
/* 1186 */       _sb_.append(this.total_crit_num);
/* 1187 */       _sb_.append(",");
/* 1188 */       _sb_.append(this.child_hood_model_cfg_id);
/* 1189 */       _sb_.append(")");
/* 1190 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChildhoodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */