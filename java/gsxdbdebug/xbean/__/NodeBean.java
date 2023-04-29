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
/*     */ public final class NodeBean extends XBean implements xbean.NodeBean
/*     */ {
/*     */   private int nodeid;
/*     */   private int finishcount;
/*     */   private HashMap<Integer, xbean.TaskBean> taskbeans;
/*     */   private long refreshtime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.nodeid = 0;
/*  25 */     this.finishcount = 0;
/*  26 */     this.taskbeans.clear();
/*  27 */     this.refreshtime = 0L;
/*     */   }
/*     */   
/*     */   NodeBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.finishcount = 0;
/*  34 */     this.taskbeans = new HashMap();
/*  35 */     this.refreshtime = 0L;
/*     */   }
/*     */   
/*     */   public NodeBean()
/*     */   {
/*  40 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public NodeBean(NodeBean _o_)
/*     */   {
/*  45 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   NodeBean(xbean.NodeBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  50 */     super(_xp_, _vn_);
/*  51 */     if ((_o1_ instanceof NodeBean)) { assign((NodeBean)_o1_);
/*  52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  54 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(NodeBean _o_) {
/*  59 */     _o_._xdb_verify_unsafe_();
/*  60 */     this.nodeid = _o_.nodeid;
/*  61 */     this.finishcount = _o_.finishcount;
/*  62 */     this.taskbeans = new HashMap();
/*  63 */     for (Map.Entry<Integer, xbean.TaskBean> _e_ : _o_.taskbeans.entrySet())
/*  64 */       this.taskbeans.put(_e_.getKey(), new TaskBean((xbean.TaskBean)_e_.getValue(), this, "taskbeans"));
/*  65 */     this.refreshtime = _o_.refreshtime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  70 */     this.nodeid = _o_.nodeid;
/*  71 */     this.finishcount = _o_.finishcount;
/*  72 */     this.taskbeans = new HashMap();
/*  73 */     for (Map.Entry<Integer, xbean.TaskBean> _e_ : _o_.taskbeans.entrySet())
/*  74 */       this.taskbeans.put(_e_.getKey(), new TaskBean((xbean.TaskBean)_e_.getValue(), this, "taskbeans"));
/*  75 */     this.refreshtime = _o_.refreshtime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  81 */     _xdb_verify_unsafe_();
/*  82 */     _os_.marshal(this.nodeid);
/*  83 */     _os_.marshal(this.finishcount);
/*  84 */     _os_.compact_uint32(this.taskbeans.size());
/*  85 */     for (Map.Entry<Integer, xbean.TaskBean> _e_ : this.taskbeans.entrySet())
/*     */     {
/*  87 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  88 */       ((xbean.TaskBean)_e_.getValue()).marshal(_os_);
/*     */     }
/*  90 */     _os_.marshal(this.refreshtime);
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     this.nodeid = _os_.unmarshal_int();
/*  99 */     this.finishcount = _os_.unmarshal_int();
/*     */     
/* 101 */     int size = _os_.uncompact_uint32();
/* 102 */     if (size >= 12)
/*     */     {
/* 104 */       this.taskbeans = new HashMap(size * 2);
/*     */     }
/* 106 */     for (; size > 0; size--)
/*     */     {
/* 108 */       int _k_ = 0;
/* 109 */       _k_ = _os_.unmarshal_int();
/* 110 */       xbean.TaskBean _v_ = new TaskBean(0, this, "taskbeans");
/* 111 */       _v_.unmarshal(_os_);
/* 112 */       this.taskbeans.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 115 */     this.refreshtime = _os_.unmarshal_long();
/* 116 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 122 */     _xdb_verify_unsafe_();
/* 123 */     int _size_ = 0;
/* 124 */     _size_ += CodedOutputStream.computeInt32Size(1, this.nodeid);
/* 125 */     _size_ += CodedOutputStream.computeInt32Size(2, this.finishcount);
/* 126 */     for (Map.Entry<Integer, xbean.TaskBean> _e_ : this.taskbeans.entrySet())
/*     */     {
/* 128 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 129 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 131 */     _size_ += CodedOutputStream.computeInt64Size(4, this.refreshtime);
/* 132 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 138 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 141 */       _output_.writeInt32(1, this.nodeid);
/* 142 */       _output_.writeInt32(2, this.finishcount);
/* 143 */       for (Map.Entry<Integer, xbean.TaskBean> _e_ : this.taskbeans.entrySet())
/*     */       {
/* 145 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 146 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 148 */       _output_.writeInt64(4, this.refreshtime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 152 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 154 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 160 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 163 */       boolean done = false;
/* 164 */       while (!done)
/*     */       {
/* 166 */         int tag = _input_.readTag();
/* 167 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 171 */           done = true;
/* 172 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 176 */           this.nodeid = _input_.readInt32();
/* 177 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 181 */           this.finishcount = _input_.readInt32();
/* 182 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 186 */           int _k_ = 0;
/* 187 */           _k_ = _input_.readInt32();
/* 188 */           int readTag = _input_.readTag();
/* 189 */           if (26 != readTag)
/*     */           {
/* 191 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 193 */           xbean.TaskBean _v_ = new TaskBean(0, this, "taskbeans");
/* 194 */           _input_.readMessage(_v_);
/* 195 */           this.taskbeans.put(Integer.valueOf(_k_), _v_);
/* 196 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 200 */           this.refreshtime = _input_.readInt64();
/* 201 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 205 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 207 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 216 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 220 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 222 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NodeBean copy()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return new NodeBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NodeBean toData()
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.NodeBean toBean()
/*     */   {
/* 241 */     _xdb_verify_unsafe_();
/* 242 */     return new NodeBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NodeBean toDataIf()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.NodeBean toBeanIf()
/*     */   {
/* 254 */     _xdb_verify_unsafe_();
/* 255 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 261 */     _xdb_verify_unsafe_();
/* 262 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNodeid()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     return this.nodeid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFinishcount()
/*     */   {
/* 277 */     _xdb_verify_unsafe_();
/* 278 */     return this.finishcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.TaskBean> getTaskbeans()
/*     */   {
/* 285 */     _xdb_verify_unsafe_();
/* 286 */     return xdb.Logs.logMap(new LogKey(this, "taskbeans"), this.taskbeans);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.TaskBean> getTaskbeansAsData()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/*     */     
/* 295 */     NodeBean _o_ = this;
/* 296 */     Map<Integer, xbean.TaskBean> taskbeans = new HashMap();
/* 297 */     for (Map.Entry<Integer, xbean.TaskBean> _e_ : _o_.taskbeans.entrySet())
/* 298 */       taskbeans.put(_e_.getKey(), new TaskBean.Data((xbean.TaskBean)_e_.getValue()));
/* 299 */     return taskbeans;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRefreshtime()
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     return this.refreshtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNodeid(int _v_)
/*     */   {
/* 314 */     _xdb_verify_unsafe_();
/* 315 */     xdb.Logs.logIf(new LogKey(this, "nodeid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 319 */         new xdb.logs.LogInt(this, NodeBean.this.nodeid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 323 */             NodeBean.this.nodeid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 327 */     });
/* 328 */     this.nodeid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFinishcount(int _v_)
/*     */   {
/* 335 */     _xdb_verify_unsafe_();
/* 336 */     xdb.Logs.logIf(new LogKey(this, "finishcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 340 */         new xdb.logs.LogInt(this, NodeBean.this.finishcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 344 */             NodeBean.this.finishcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 348 */     });
/* 349 */     this.finishcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRefreshtime(long _v_)
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     xdb.Logs.logIf(new LogKey(this, "refreshtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 361 */         new xdb.logs.LogLong(this, NodeBean.this.refreshtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 365 */             NodeBean.this.refreshtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 369 */     });
/* 370 */     this.refreshtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 376 */     _xdb_verify_unsafe_();
/* 377 */     NodeBean _o_ = null;
/* 378 */     if ((_o1_ instanceof NodeBean)) { _o_ = (NodeBean)_o1_;
/* 379 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 380 */       return false;
/* 381 */     if (this.nodeid != _o_.nodeid) return false;
/* 382 */     if (this.finishcount != _o_.finishcount) return false;
/* 383 */     if (!this.taskbeans.equals(_o_.taskbeans)) return false;
/* 384 */     if (this.refreshtime != _o_.refreshtime) return false;
/* 385 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 391 */     _xdb_verify_unsafe_();
/* 392 */     int _h_ = 0;
/* 393 */     _h_ += this.nodeid;
/* 394 */     _h_ += this.finishcount;
/* 395 */     _h_ += this.taskbeans.hashCode();
/* 396 */     _h_ = (int)(_h_ + this.refreshtime);
/* 397 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 403 */     _xdb_verify_unsafe_();
/* 404 */     StringBuilder _sb_ = new StringBuilder();
/* 405 */     _sb_.append("(");
/* 406 */     _sb_.append(this.nodeid);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.finishcount);
/* 409 */     _sb_.append(",");
/* 410 */     _sb_.append(this.taskbeans);
/* 411 */     _sb_.append(",");
/* 412 */     _sb_.append(this.refreshtime);
/* 413 */     _sb_.append(")");
/* 414 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 420 */     ListenableBean lb = new ListenableBean();
/* 421 */     lb.add(new xdb.logs.ListenableChanged().setVarName("nodeid"));
/* 422 */     lb.add(new xdb.logs.ListenableChanged().setVarName("finishcount"));
/* 423 */     lb.add(new xdb.logs.ListenableMap().setVarName("taskbeans"));
/* 424 */     lb.add(new xdb.logs.ListenableChanged().setVarName("refreshtime"));
/* 425 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.NodeBean {
/*     */     private Const() {}
/*     */     
/*     */     NodeBean nThis() {
/* 432 */       return NodeBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 438 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NodeBean copy()
/*     */     {
/* 444 */       return NodeBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NodeBean toData()
/*     */     {
/* 450 */       return NodeBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.NodeBean toBean()
/*     */     {
/* 455 */       return NodeBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NodeBean toDataIf()
/*     */     {
/* 461 */       return NodeBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.NodeBean toBeanIf()
/*     */     {
/* 466 */       return NodeBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNodeid()
/*     */     {
/* 473 */       NodeBean.this._xdb_verify_unsafe_();
/* 474 */       return NodeBean.this.nodeid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFinishcount()
/*     */     {
/* 481 */       NodeBean.this._xdb_verify_unsafe_();
/* 482 */       return NodeBean.this.finishcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TaskBean> getTaskbeans()
/*     */     {
/* 489 */       NodeBean.this._xdb_verify_unsafe_();
/* 490 */       return xdb.Consts.constMap(NodeBean.this.taskbeans);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TaskBean> getTaskbeansAsData()
/*     */     {
/* 497 */       NodeBean.this._xdb_verify_unsafe_();
/*     */       
/* 499 */       NodeBean _o_ = NodeBean.this;
/* 500 */       Map<Integer, xbean.TaskBean> taskbeans = new HashMap();
/* 501 */       for (Map.Entry<Integer, xbean.TaskBean> _e_ : _o_.taskbeans.entrySet())
/* 502 */         taskbeans.put(_e_.getKey(), new TaskBean.Data((xbean.TaskBean)_e_.getValue()));
/* 503 */       return taskbeans;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRefreshtime()
/*     */     {
/* 510 */       NodeBean.this._xdb_verify_unsafe_();
/* 511 */       return NodeBean.this.refreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNodeid(int _v_)
/*     */     {
/* 518 */       NodeBean.this._xdb_verify_unsafe_();
/* 519 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinishcount(int _v_)
/*     */     {
/* 526 */       NodeBean.this._xdb_verify_unsafe_();
/* 527 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRefreshtime(long _v_)
/*     */     {
/* 534 */       NodeBean.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 541 */       NodeBean.this._xdb_verify_unsafe_();
/* 542 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 548 */       NodeBean.this._xdb_verify_unsafe_();
/* 549 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 555 */       return NodeBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 561 */       return NodeBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 567 */       NodeBean.this._xdb_verify_unsafe_();
/* 568 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 574 */       return NodeBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 580 */       return NodeBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 586 */       NodeBean.this._xdb_verify_unsafe_();
/* 587 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 593 */       return NodeBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 599 */       return NodeBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 605 */       return NodeBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 611 */       return NodeBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 617 */       return NodeBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 623 */       return NodeBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 629 */       return NodeBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.NodeBean
/*     */   {
/*     */     private int nodeid;
/*     */     
/*     */     private int finishcount;
/*     */     
/*     */     private HashMap<Integer, xbean.TaskBean> taskbeans;
/*     */     
/*     */     private long refreshtime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 647 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 652 */       this.finishcount = 0;
/* 653 */       this.taskbeans = new HashMap();
/* 654 */       this.refreshtime = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.NodeBean _o1_)
/*     */     {
/* 659 */       if ((_o1_ instanceof NodeBean)) { assign((NodeBean)_o1_);
/* 660 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 661 */       } else if ((_o1_ instanceof NodeBean.Const)) assign(((NodeBean.Const)_o1_).nThis()); else {
/* 662 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(NodeBean _o_) {
/* 667 */       this.nodeid = _o_.nodeid;
/* 668 */       this.finishcount = _o_.finishcount;
/* 669 */       this.taskbeans = new HashMap();
/* 670 */       for (Map.Entry<Integer, xbean.TaskBean> _e_ : _o_.taskbeans.entrySet())
/* 671 */         this.taskbeans.put(_e_.getKey(), new TaskBean.Data((xbean.TaskBean)_e_.getValue()));
/* 672 */       this.refreshtime = _o_.refreshtime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 677 */       this.nodeid = _o_.nodeid;
/* 678 */       this.finishcount = _o_.finishcount;
/* 679 */       this.taskbeans = new HashMap();
/* 680 */       for (Map.Entry<Integer, xbean.TaskBean> _e_ : _o_.taskbeans.entrySet())
/* 681 */         this.taskbeans.put(_e_.getKey(), new TaskBean.Data((xbean.TaskBean)_e_.getValue()));
/* 682 */       this.refreshtime = _o_.refreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 688 */       _os_.marshal(this.nodeid);
/* 689 */       _os_.marshal(this.finishcount);
/* 690 */       _os_.compact_uint32(this.taskbeans.size());
/* 691 */       for (Map.Entry<Integer, xbean.TaskBean> _e_ : this.taskbeans.entrySet())
/*     */       {
/* 693 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 694 */         ((xbean.TaskBean)_e_.getValue()).marshal(_os_);
/*     */       }
/* 696 */       _os_.marshal(this.refreshtime);
/* 697 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 703 */       this.nodeid = _os_.unmarshal_int();
/* 704 */       this.finishcount = _os_.unmarshal_int();
/*     */       
/* 706 */       int size = _os_.uncompact_uint32();
/* 707 */       if (size >= 12)
/*     */       {
/* 709 */         this.taskbeans = new HashMap(size * 2);
/*     */       }
/* 711 */       for (; size > 0; size--)
/*     */       {
/* 713 */         int _k_ = 0;
/* 714 */         _k_ = _os_.unmarshal_int();
/* 715 */         xbean.TaskBean _v_ = xbean.Pod.newTaskBeanData();
/* 716 */         _v_.unmarshal(_os_);
/* 717 */         this.taskbeans.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 720 */       this.refreshtime = _os_.unmarshal_long();
/* 721 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 727 */       int _size_ = 0;
/* 728 */       _size_ += CodedOutputStream.computeInt32Size(1, this.nodeid);
/* 729 */       _size_ += CodedOutputStream.computeInt32Size(2, this.finishcount);
/* 730 */       for (Map.Entry<Integer, xbean.TaskBean> _e_ : this.taskbeans.entrySet())
/*     */       {
/* 732 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 733 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 735 */       _size_ += CodedOutputStream.computeInt64Size(4, this.refreshtime);
/* 736 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 744 */         _output_.writeInt32(1, this.nodeid);
/* 745 */         _output_.writeInt32(2, this.finishcount);
/* 746 */         for (Map.Entry<Integer, xbean.TaskBean> _e_ : this.taskbeans.entrySet())
/*     */         {
/* 748 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 749 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/* 751 */         _output_.writeInt64(4, this.refreshtime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 755 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 757 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 765 */         boolean done = false;
/* 766 */         while (!done)
/*     */         {
/* 768 */           int tag = _input_.readTag();
/* 769 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 773 */             done = true;
/* 774 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 778 */             this.nodeid = _input_.readInt32();
/* 779 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 783 */             this.finishcount = _input_.readInt32();
/* 784 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 788 */             int _k_ = 0;
/* 789 */             _k_ = _input_.readInt32();
/* 790 */             int readTag = _input_.readTag();
/* 791 */             if (26 != readTag)
/*     */             {
/* 793 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 795 */             xbean.TaskBean _v_ = xbean.Pod.newTaskBeanData();
/* 796 */             _input_.readMessage(_v_);
/* 797 */             this.taskbeans.put(Integer.valueOf(_k_), _v_);
/* 798 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 802 */             this.refreshtime = _input_.readInt64();
/* 803 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 807 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 809 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 818 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 822 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 824 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NodeBean copy()
/*     */     {
/* 830 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NodeBean toData()
/*     */     {
/* 836 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.NodeBean toBean()
/*     */     {
/* 841 */       return new NodeBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NodeBean toDataIf()
/*     */     {
/* 847 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.NodeBean toBeanIf()
/*     */     {
/* 852 */       return new NodeBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 858 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 862 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 866 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 874 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 878 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 882 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNodeid()
/*     */     {
/* 889 */       return this.nodeid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFinishcount()
/*     */     {
/* 896 */       return this.finishcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TaskBean> getTaskbeans()
/*     */     {
/* 903 */       return this.taskbeans;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.TaskBean> getTaskbeansAsData()
/*     */     {
/* 910 */       return this.taskbeans;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRefreshtime()
/*     */     {
/* 917 */       return this.refreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNodeid(int _v_)
/*     */     {
/* 924 */       this.nodeid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFinishcount(int _v_)
/*     */     {
/* 931 */       this.finishcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRefreshtime(long _v_)
/*     */     {
/* 938 */       this.refreshtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 944 */       if (!(_o1_ instanceof Data)) return false;
/* 945 */       Data _o_ = (Data)_o1_;
/* 946 */       if (this.nodeid != _o_.nodeid) return false;
/* 947 */       if (this.finishcount != _o_.finishcount) return false;
/* 948 */       if (!this.taskbeans.equals(_o_.taskbeans)) return false;
/* 949 */       if (this.refreshtime != _o_.refreshtime) return false;
/* 950 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 956 */       int _h_ = 0;
/* 957 */       _h_ += this.nodeid;
/* 958 */       _h_ += this.finishcount;
/* 959 */       _h_ += this.taskbeans.hashCode();
/* 960 */       _h_ = (int)(_h_ + this.refreshtime);
/* 961 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 967 */       StringBuilder _sb_ = new StringBuilder();
/* 968 */       _sb_.append("(");
/* 969 */       _sb_.append(this.nodeid);
/* 970 */       _sb_.append(",");
/* 971 */       _sb_.append(this.finishcount);
/* 972 */       _sb_.append(",");
/* 973 */       _sb_.append(this.taskbeans);
/* 974 */       _sb_.append(",");
/* 975 */       _sb_.append(this.refreshtime);
/* 976 */       _sb_.append(")");
/* 977 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\NodeBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */