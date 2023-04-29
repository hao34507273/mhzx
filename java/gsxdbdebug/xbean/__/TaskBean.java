/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class TaskBean extends XBean implements xbean.TaskBean
/*     */ {
/*     */   private int taskid;
/*     */   private int taskstate;
/*     */   private HashMap<Integer, xbean.ConBean> conmap;
/*     */   private long taskstarttime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.taskid = 0;
/*  25 */     this.taskstate = 0;
/*  26 */     this.conmap.clear();
/*  27 */     this.taskstarttime = 0L;
/*     */   }
/*     */   
/*     */   TaskBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.conmap = new HashMap();
/*     */   }
/*     */   
/*     */   public TaskBean()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public TaskBean(TaskBean _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   TaskBean(xbean.TaskBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof TaskBean)) { assign((TaskBean)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(TaskBean _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.taskid = _o_.taskid;
/*  59 */     this.taskstate = _o_.taskstate;
/*  60 */     this.conmap = new HashMap();
/*  61 */     for (Map.Entry<Integer, xbean.ConBean> _e_ : _o_.conmap.entrySet())
/*  62 */       this.conmap.put(_e_.getKey(), new ConBean((xbean.ConBean)_e_.getValue(), this, "conmap"));
/*  63 */     this.taskstarttime = _o_.taskstarttime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  68 */     this.taskid = _o_.taskid;
/*  69 */     this.taskstate = _o_.taskstate;
/*  70 */     this.conmap = new HashMap();
/*  71 */     for (Map.Entry<Integer, xbean.ConBean> _e_ : _o_.conmap.entrySet())
/*  72 */       this.conmap.put(_e_.getKey(), new ConBean((xbean.ConBean)_e_.getValue(), this, "conmap"));
/*  73 */     this.taskstarttime = _o_.taskstarttime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.taskid);
/*  81 */     _os_.marshal(this.taskstate);
/*  82 */     _os_.compact_uint32(this.conmap.size());
/*  83 */     for (Map.Entry<Integer, xbean.ConBean> _e_ : this.conmap.entrySet())
/*     */     {
/*  85 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  86 */       ((xbean.ConBean)_e_.getValue()).marshal(_os_);
/*     */     }
/*  88 */     _os_.marshal(this.taskstarttime);
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  95 */     _xdb_verify_unsafe_();
/*  96 */     this.taskid = _os_.unmarshal_int();
/*  97 */     this.taskstate = _os_.unmarshal_int();
/*     */     
/*  99 */     int size = _os_.uncompact_uint32();
/* 100 */     if (size >= 12)
/*     */     {
/* 102 */       this.conmap = new HashMap(size * 2);
/*     */     }
/* 104 */     for (; size > 0; size--)
/*     */     {
/* 106 */       int _k_ = 0;
/* 107 */       _k_ = _os_.unmarshal_int();
/* 108 */       xbean.ConBean _v_ = new ConBean(0, this, "conmap");
/* 109 */       _v_.unmarshal(_os_);
/* 110 */       this.conmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 113 */     this.taskstarttime = _os_.unmarshal_long();
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     _size_ += CodedOutputStream.computeInt32Size(1, this.taskid);
/* 123 */     _size_ += CodedOutputStream.computeInt32Size(2, this.taskstate);
/* 124 */     for (Map.Entry<Integer, xbean.ConBean> _e_ : this.conmap.entrySet())
/*     */     {
/* 126 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 127 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 129 */     _size_ += CodedOutputStream.computeInt64Size(4, this.taskstarttime);
/* 130 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 136 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 139 */       _output_.writeInt32(1, this.taskid);
/* 140 */       _output_.writeInt32(2, this.taskstate);
/* 141 */       for (Map.Entry<Integer, xbean.ConBean> _e_ : this.conmap.entrySet())
/*     */       {
/* 143 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 144 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 146 */       _output_.writeInt64(4, this.taskstarttime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 150 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 152 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 158 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 161 */       boolean done = false;
/* 162 */       while (!done)
/*     */       {
/* 164 */         int tag = _input_.readTag();
/* 165 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 169 */           done = true;
/* 170 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 174 */           this.taskid = _input_.readInt32();
/* 175 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 179 */           this.taskstate = _input_.readInt32();
/* 180 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 184 */           int _k_ = 0;
/* 185 */           _k_ = _input_.readInt32();
/* 186 */           int readTag = _input_.readTag();
/* 187 */           if (26 != readTag)
/*     */           {
/* 189 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 191 */           xbean.ConBean _v_ = new ConBean(0, this, "conmap");
/* 192 */           _input_.readMessage(_v_);
/* 193 */           this.conmap.put(Integer.valueOf(_k_), _v_);
/* 194 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 198 */           this.taskstarttime = _input_.readInt64();
/* 199 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 203 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 205 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 214 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 218 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 220 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TaskBean copy()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return new TaskBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TaskBean toData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TaskBean toBean()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     return new TaskBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.TaskBean toDataIf()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.TaskBean toBeanIf()
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTaskid()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return this.taskid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTaskstate()
/*     */   {
/* 275 */     _xdb_verify_unsafe_();
/* 276 */     return this.taskstate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.ConBean> getConmap()
/*     */   {
/* 283 */     _xdb_verify_unsafe_();
/* 284 */     return xdb.Logs.logMap(new LogKey(this, "conmap"), this.conmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.ConBean> getConmapAsData()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/*     */     
/* 293 */     TaskBean _o_ = this;
/* 294 */     Map<Integer, xbean.ConBean> conmap = new HashMap();
/* 295 */     for (Map.Entry<Integer, xbean.ConBean> _e_ : _o_.conmap.entrySet())
/* 296 */       conmap.put(_e_.getKey(), new ConBean.Data((xbean.ConBean)_e_.getValue()));
/* 297 */     return conmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getTaskstarttime()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     return this.taskstarttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTaskid(int _v_)
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     xdb.Logs.logIf(new LogKey(this, "taskid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 317 */         new xdb.logs.LogInt(this, TaskBean.this.taskid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 321 */             TaskBean.this.taskid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 325 */     });
/* 326 */     this.taskid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTaskstate(int _v_)
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     xdb.Logs.logIf(new LogKey(this, "taskstate")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 338 */         new xdb.logs.LogInt(this, TaskBean.this.taskstate)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 342 */             TaskBean.this.taskstate = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 346 */     });
/* 347 */     this.taskstate = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTaskstarttime(long _v_)
/*     */   {
/* 354 */     _xdb_verify_unsafe_();
/* 355 */     xdb.Logs.logIf(new LogKey(this, "taskstarttime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 359 */         new xdb.logs.LogLong(this, TaskBean.this.taskstarttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 363 */             TaskBean.this.taskstarttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 367 */     });
/* 368 */     this.taskstarttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 374 */     _xdb_verify_unsafe_();
/* 375 */     TaskBean _o_ = null;
/* 376 */     if ((_o1_ instanceof TaskBean)) { _o_ = (TaskBean)_o1_;
/* 377 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 378 */       return false;
/* 379 */     if (this.taskid != _o_.taskid) return false;
/* 380 */     if (this.taskstate != _o_.taskstate) return false;
/* 381 */     if (!this.conmap.equals(_o_.conmap)) return false;
/* 382 */     if (this.taskstarttime != _o_.taskstarttime) return false;
/* 383 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 389 */     _xdb_verify_unsafe_();
/* 390 */     int _h_ = 0;
/* 391 */     _h_ += this.taskid;
/* 392 */     _h_ += this.taskstate;
/* 393 */     _h_ += this.conmap.hashCode();
/* 394 */     _h_ = (int)(_h_ + this.taskstarttime);
/* 395 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 401 */     _xdb_verify_unsafe_();
/* 402 */     StringBuilder _sb_ = new StringBuilder();
/* 403 */     _sb_.append("(");
/* 404 */     _sb_.append(this.taskid);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.taskstate);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.conmap);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.taskstarttime);
/* 411 */     _sb_.append(")");
/* 412 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 418 */     ListenableBean lb = new ListenableBean();
/* 419 */     lb.add(new xdb.logs.ListenableChanged().setVarName("taskid"));
/* 420 */     lb.add(new xdb.logs.ListenableChanged().setVarName("taskstate"));
/* 421 */     lb.add(new xdb.logs.ListenableMap().setVarName("conmap"));
/* 422 */     lb.add(new xdb.logs.ListenableChanged().setVarName("taskstarttime"));
/* 423 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.TaskBean {
/*     */     private Const() {}
/*     */     
/*     */     TaskBean nThis() {
/* 430 */       return TaskBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TaskBean copy()
/*     */     {
/* 442 */       return TaskBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TaskBean toData()
/*     */     {
/* 448 */       return TaskBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.TaskBean toBean()
/*     */     {
/* 453 */       return TaskBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TaskBean toDataIf()
/*     */     {
/* 459 */       return TaskBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.TaskBean toBeanIf()
/*     */     {
/* 464 */       return TaskBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTaskid()
/*     */     {
/* 471 */       TaskBean.this._xdb_verify_unsafe_();
/* 472 */       return TaskBean.this.taskid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTaskstate()
/*     */     {
/* 479 */       TaskBean.this._xdb_verify_unsafe_();
/* 480 */       return TaskBean.this.taskstate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.ConBean> getConmap()
/*     */     {
/* 487 */       TaskBean.this._xdb_verify_unsafe_();
/* 488 */       return xdb.Consts.constMap(TaskBean.this.conmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.ConBean> getConmapAsData()
/*     */     {
/* 495 */       TaskBean.this._xdb_verify_unsafe_();
/*     */       
/* 497 */       TaskBean _o_ = TaskBean.this;
/* 498 */       Map<Integer, xbean.ConBean> conmap = new HashMap();
/* 499 */       for (Map.Entry<Integer, xbean.ConBean> _e_ : _o_.conmap.entrySet())
/* 500 */         conmap.put(_e_.getKey(), new ConBean.Data((xbean.ConBean)_e_.getValue()));
/* 501 */       return conmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTaskstarttime()
/*     */     {
/* 508 */       TaskBean.this._xdb_verify_unsafe_();
/* 509 */       return TaskBean.this.taskstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaskid(int _v_)
/*     */     {
/* 516 */       TaskBean.this._xdb_verify_unsafe_();
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaskstate(int _v_)
/*     */     {
/* 524 */       TaskBean.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaskstarttime(long _v_)
/*     */     {
/* 532 */       TaskBean.this._xdb_verify_unsafe_();
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 539 */       TaskBean.this._xdb_verify_unsafe_();
/* 540 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 546 */       TaskBean.this._xdb_verify_unsafe_();
/* 547 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 553 */       return TaskBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 559 */       return TaskBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       TaskBean.this._xdb_verify_unsafe_();
/* 566 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 572 */       return TaskBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 578 */       return TaskBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 584 */       TaskBean.this._xdb_verify_unsafe_();
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 591 */       return TaskBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 597 */       return TaskBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 603 */       return TaskBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 609 */       return TaskBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 615 */       return TaskBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 621 */       return TaskBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 627 */       return TaskBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.TaskBean
/*     */   {
/*     */     private int taskid;
/*     */     
/*     */     private int taskstate;
/*     */     
/*     */     private HashMap<Integer, xbean.ConBean> conmap;
/*     */     
/*     */     private long taskstarttime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 645 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 650 */       this.conmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.TaskBean _o1_)
/*     */     {
/* 655 */       if ((_o1_ instanceof TaskBean)) { assign((TaskBean)_o1_);
/* 656 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 657 */       } else if ((_o1_ instanceof TaskBean.Const)) assign(((TaskBean.Const)_o1_).nThis()); else {
/* 658 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(TaskBean _o_) {
/* 663 */       this.taskid = _o_.taskid;
/* 664 */       this.taskstate = _o_.taskstate;
/* 665 */       this.conmap = new HashMap();
/* 666 */       for (Map.Entry<Integer, xbean.ConBean> _e_ : _o_.conmap.entrySet())
/* 667 */         this.conmap.put(_e_.getKey(), new ConBean.Data((xbean.ConBean)_e_.getValue()));
/* 668 */       this.taskstarttime = _o_.taskstarttime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 673 */       this.taskid = _o_.taskid;
/* 674 */       this.taskstate = _o_.taskstate;
/* 675 */       this.conmap = new HashMap();
/* 676 */       for (Map.Entry<Integer, xbean.ConBean> _e_ : _o_.conmap.entrySet())
/* 677 */         this.conmap.put(_e_.getKey(), new ConBean.Data((xbean.ConBean)_e_.getValue()));
/* 678 */       this.taskstarttime = _o_.taskstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 684 */       _os_.marshal(this.taskid);
/* 685 */       _os_.marshal(this.taskstate);
/* 686 */       _os_.compact_uint32(this.conmap.size());
/* 687 */       for (Map.Entry<Integer, xbean.ConBean> _e_ : this.conmap.entrySet())
/*     */       {
/* 689 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 690 */         ((xbean.ConBean)_e_.getValue()).marshal(_os_);
/*     */       }
/* 692 */       _os_.marshal(this.taskstarttime);
/* 693 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 699 */       this.taskid = _os_.unmarshal_int();
/* 700 */       this.taskstate = _os_.unmarshal_int();
/*     */       
/* 702 */       int size = _os_.uncompact_uint32();
/* 703 */       if (size >= 12)
/*     */       {
/* 705 */         this.conmap = new HashMap(size * 2);
/*     */       }
/* 707 */       for (; size > 0; size--)
/*     */       {
/* 709 */         int _k_ = 0;
/* 710 */         _k_ = _os_.unmarshal_int();
/* 711 */         xbean.ConBean _v_ = xbean.Pod.newConBeanData();
/* 712 */         _v_.unmarshal(_os_);
/* 713 */         this.conmap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 716 */       this.taskstarttime = _os_.unmarshal_long();
/* 717 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 723 */       int _size_ = 0;
/* 724 */       _size_ += CodedOutputStream.computeInt32Size(1, this.taskid);
/* 725 */       _size_ += CodedOutputStream.computeInt32Size(2, this.taskstate);
/* 726 */       for (Map.Entry<Integer, xbean.ConBean> _e_ : this.conmap.entrySet())
/*     */       {
/* 728 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 729 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 731 */       _size_ += CodedOutputStream.computeInt64Size(4, this.taskstarttime);
/* 732 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 740 */         _output_.writeInt32(1, this.taskid);
/* 741 */         _output_.writeInt32(2, this.taskstate);
/* 742 */         for (Map.Entry<Integer, xbean.ConBean> _e_ : this.conmap.entrySet())
/*     */         {
/* 744 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 745 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/* 747 */         _output_.writeInt64(4, this.taskstarttime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 751 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 753 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 761 */         boolean done = false;
/* 762 */         while (!done)
/*     */         {
/* 764 */           int tag = _input_.readTag();
/* 765 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 769 */             done = true;
/* 770 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 774 */             this.taskid = _input_.readInt32();
/* 775 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 779 */             this.taskstate = _input_.readInt32();
/* 780 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 784 */             int _k_ = 0;
/* 785 */             _k_ = _input_.readInt32();
/* 786 */             int readTag = _input_.readTag();
/* 787 */             if (26 != readTag)
/*     */             {
/* 789 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 791 */             xbean.ConBean _v_ = xbean.Pod.newConBeanData();
/* 792 */             _input_.readMessage(_v_);
/* 793 */             this.conmap.put(Integer.valueOf(_k_), _v_);
/* 794 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 798 */             this.taskstarttime = _input_.readInt64();
/* 799 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 803 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 805 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 814 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 818 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 820 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TaskBean copy()
/*     */     {
/* 826 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TaskBean toData()
/*     */     {
/* 832 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.TaskBean toBean()
/*     */     {
/* 837 */       return new TaskBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.TaskBean toDataIf()
/*     */     {
/* 843 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.TaskBean toBeanIf()
/*     */     {
/* 848 */       return new TaskBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 854 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 874 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 878 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTaskid()
/*     */     {
/* 885 */       return this.taskid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTaskstate()
/*     */     {
/* 892 */       return this.taskstate;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.ConBean> getConmap()
/*     */     {
/* 899 */       return this.conmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.ConBean> getConmapAsData()
/*     */     {
/* 906 */       return this.conmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getTaskstarttime()
/*     */     {
/* 913 */       return this.taskstarttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaskid(int _v_)
/*     */     {
/* 920 */       this.taskid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaskstate(int _v_)
/*     */     {
/* 927 */       this.taskstate = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaskstarttime(long _v_)
/*     */     {
/* 934 */       this.taskstarttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 940 */       if (!(_o1_ instanceof Data)) return false;
/* 941 */       Data _o_ = (Data)_o1_;
/* 942 */       if (this.taskid != _o_.taskid) return false;
/* 943 */       if (this.taskstate != _o_.taskstate) return false;
/* 944 */       if (!this.conmap.equals(_o_.conmap)) return false;
/* 945 */       if (this.taskstarttime != _o_.taskstarttime) return false;
/* 946 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 952 */       int _h_ = 0;
/* 953 */       _h_ += this.taskid;
/* 954 */       _h_ += this.taskstate;
/* 955 */       _h_ += this.conmap.hashCode();
/* 956 */       _h_ = (int)(_h_ + this.taskstarttime);
/* 957 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 963 */       StringBuilder _sb_ = new StringBuilder();
/* 964 */       _sb_.append("(");
/* 965 */       _sb_.append(this.taskid);
/* 966 */       _sb_.append(",");
/* 967 */       _sb_.append(this.taskstate);
/* 968 */       _sb_.append(",");
/* 969 */       _sb_.append(this.conmap);
/* 970 */       _sb_.append(",");
/* 971 */       _sb_.append(this.taskstarttime);
/* 972 */       _sb_.append(")");
/* 973 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TaskBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */