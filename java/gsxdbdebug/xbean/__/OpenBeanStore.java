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
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class OpenBeanStore extends XBean implements xbean.OpenBeanStore
/*      */ {
/*      */   private long endtime;
/*      */   private int activityduration;
/*      */   private HashMap<Integer, xbean.StageBean> stagemap;
/*      */   private int stage;
/*      */   private long cleardatatime;
/*      */   private int openstate;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.endtime = 0L;
/*   29 */     this.activityduration = 0;
/*   30 */     this.stagemap.clear();
/*   31 */     this.stage = 0;
/*   32 */     this.cleardatatime = 0L;
/*   33 */     this.openstate = 0;
/*      */   }
/*      */   
/*      */   OpenBeanStore(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.stagemap = new HashMap();
/*      */   }
/*      */   
/*      */   public OpenBeanStore()
/*      */   {
/*   44 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public OpenBeanStore(OpenBeanStore _o_)
/*      */   {
/*   49 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   OpenBeanStore(xbean.OpenBeanStore _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   54 */     super(_xp_, _vn_);
/*   55 */     if ((_o1_ instanceof OpenBeanStore)) { assign((OpenBeanStore)_o1_);
/*   56 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   57 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   58 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(OpenBeanStore _o_) {
/*   63 */     _o_._xdb_verify_unsafe_();
/*   64 */     this.endtime = _o_.endtime;
/*   65 */     this.activityduration = _o_.activityduration;
/*   66 */     this.stagemap = new HashMap();
/*   67 */     for (Map.Entry<Integer, xbean.StageBean> _e_ : _o_.stagemap.entrySet())
/*   68 */       this.stagemap.put(_e_.getKey(), new StageBean((xbean.StageBean)_e_.getValue(), this, "stagemap"));
/*   69 */     this.stage = _o_.stage;
/*   70 */     this.cleardatatime = _o_.cleardatatime;
/*   71 */     this.openstate = _o_.openstate;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   76 */     this.endtime = _o_.endtime;
/*   77 */     this.activityduration = _o_.activityduration;
/*   78 */     this.stagemap = new HashMap();
/*   79 */     for (Map.Entry<Integer, xbean.StageBean> _e_ : _o_.stagemap.entrySet())
/*   80 */       this.stagemap.put(_e_.getKey(), new StageBean((xbean.StageBean)_e_.getValue(), this, "stagemap"));
/*   81 */     this.stage = _o_.stage;
/*   82 */     this.cleardatatime = _o_.cleardatatime;
/*   83 */     this.openstate = _o_.openstate;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.marshal(this.endtime);
/*   91 */     _os_.marshal(this.activityduration);
/*   92 */     _os_.compact_uint32(this.stagemap.size());
/*   93 */     for (Map.Entry<Integer, xbean.StageBean> _e_ : this.stagemap.entrySet())
/*      */     {
/*   95 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   96 */       ((xbean.StageBean)_e_.getValue()).marshal(_os_);
/*      */     }
/*   98 */     _os_.marshal(this.stage);
/*   99 */     _os_.marshal(this.cleardatatime);
/*  100 */     _os_.marshal(this.openstate);
/*  101 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  107 */     _xdb_verify_unsafe_();
/*  108 */     this.endtime = _os_.unmarshal_long();
/*  109 */     this.activityduration = _os_.unmarshal_int();
/*      */     
/*  111 */     int size = _os_.uncompact_uint32();
/*  112 */     if (size >= 12)
/*      */     {
/*  114 */       this.stagemap = new HashMap(size * 2);
/*      */     }
/*  116 */     for (; size > 0; size--)
/*      */     {
/*  118 */       int _k_ = 0;
/*  119 */       _k_ = _os_.unmarshal_int();
/*  120 */       xbean.StageBean _v_ = new StageBean(0, this, "stagemap");
/*  121 */       _v_.unmarshal(_os_);
/*  122 */       this.stagemap.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  125 */     this.stage = _os_.unmarshal_int();
/*  126 */     this.cleardatatime = _os_.unmarshal_long();
/*  127 */     this.openstate = _os_.unmarshal_int();
/*  128 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  134 */     _xdb_verify_unsafe_();
/*  135 */     int _size_ = 0;
/*  136 */     _size_ += CodedOutputStream.computeInt64Size(1, this.endtime);
/*  137 */     _size_ += CodedOutputStream.computeInt32Size(2, this.activityduration);
/*  138 */     for (Map.Entry<Integer, xbean.StageBean> _e_ : this.stagemap.entrySet())
/*      */     {
/*  140 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  141 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */     }
/*  143 */     _size_ += CodedOutputStream.computeInt32Size(4, this.stage);
/*  144 */     _size_ += CodedOutputStream.computeInt64Size(5, this.cleardatatime);
/*  145 */     _size_ += CodedOutputStream.computeInt32Size(6, this.openstate);
/*  146 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  152 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  155 */       _output_.writeInt64(1, this.endtime);
/*  156 */       _output_.writeInt32(2, this.activityduration);
/*  157 */       for (Map.Entry<Integer, xbean.StageBean> _e_ : this.stagemap.entrySet())
/*      */       {
/*  159 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  160 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  162 */       _output_.writeInt32(4, this.stage);
/*  163 */       _output_.writeInt64(5, this.cleardatatime);
/*  164 */       _output_.writeInt32(6, this.openstate);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  168 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  170 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  176 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  179 */       boolean done = false;
/*  180 */       while (!done)
/*      */       {
/*  182 */         int tag = _input_.readTag();
/*  183 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  187 */           done = true;
/*  188 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  192 */           this.endtime = _input_.readInt64();
/*  193 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  197 */           this.activityduration = _input_.readInt32();
/*  198 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  202 */           int _k_ = 0;
/*  203 */           _k_ = _input_.readInt32();
/*  204 */           int readTag = _input_.readTag();
/*  205 */           if (26 != readTag)
/*      */           {
/*  207 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  209 */           xbean.StageBean _v_ = new StageBean(0, this, "stagemap");
/*  210 */           _input_.readMessage(_v_);
/*  211 */           this.stagemap.put(Integer.valueOf(_k_), _v_);
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  216 */           this.stage = _input_.readInt32();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  221 */           this.cleardatatime = _input_.readInt64();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  226 */           this.openstate = _input_.readInt32();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  231 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  233 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  242 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  246 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  248 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OpenBeanStore copy()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new OpenBeanStore(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OpenBeanStore toData()
/*      */   {
/*  261 */     _xdb_verify_unsafe_();
/*  262 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.OpenBeanStore toBean()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new OpenBeanStore(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.OpenBeanStore toDataIf()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.OpenBeanStore toBeanIf()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEndtime()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return this.endtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActivityduration()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return this.activityduration;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.StageBean> getStagemap()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return xdb.Logs.logMap(new LogKey(this, "stagemap"), this.stagemap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.StageBean> getStagemapAsData()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*      */     
/*  321 */     OpenBeanStore _o_ = this;
/*  322 */     Map<Integer, xbean.StageBean> stagemap = new HashMap();
/*  323 */     for (Map.Entry<Integer, xbean.StageBean> _e_ : _o_.stagemap.entrySet())
/*  324 */       stagemap.put(_e_.getKey(), new StageBean.Data((xbean.StageBean)_e_.getValue()));
/*  325 */     return stagemap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStage()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return this.stage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCleardatatime()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return this.cleardatatime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getOpenstate()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this.openstate;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEndtime(long _v_)
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     xdb.Logs.logIf(new LogKey(this, "endtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  361 */         new xdb.logs.LogLong(this, OpenBeanStore.this.endtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  365 */             OpenBeanStore.this.endtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  369 */     });
/*  370 */     this.endtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivityduration(int _v_)
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     xdb.Logs.logIf(new LogKey(this, "activityduration")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  382 */         new LogInt(this, OpenBeanStore.this.activityduration)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  386 */             OpenBeanStore.this.activityduration = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  390 */     });
/*  391 */     this.activityduration = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStage(int _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     xdb.Logs.logIf(new LogKey(this, "stage")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  403 */         new LogInt(this, OpenBeanStore.this.stage)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             OpenBeanStore.this.stage = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.stage = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCleardatatime(long _v_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     xdb.Logs.logIf(new LogKey(this, "cleardatatime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  424 */         new xdb.logs.LogLong(this, OpenBeanStore.this.cleardatatime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  428 */             OpenBeanStore.this.cleardatatime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  432 */     });
/*  433 */     this.cleardatatime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOpenstate(int _v_)
/*      */   {
/*  440 */     _xdb_verify_unsafe_();
/*  441 */     xdb.Logs.logIf(new LogKey(this, "openstate")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  445 */         new LogInt(this, OpenBeanStore.this.openstate)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  449 */             OpenBeanStore.this.openstate = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  453 */     });
/*  454 */     this.openstate = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  460 */     _xdb_verify_unsafe_();
/*  461 */     OpenBeanStore _o_ = null;
/*  462 */     if ((_o1_ instanceof OpenBeanStore)) { _o_ = (OpenBeanStore)_o1_;
/*  463 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  464 */       return false;
/*  465 */     if (this.endtime != _o_.endtime) return false;
/*  466 */     if (this.activityduration != _o_.activityduration) return false;
/*  467 */     if (!this.stagemap.equals(_o_.stagemap)) return false;
/*  468 */     if (this.stage != _o_.stage) return false;
/*  469 */     if (this.cleardatatime != _o_.cleardatatime) return false;
/*  470 */     if (this.openstate != _o_.openstate) return false;
/*  471 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     int _h_ = 0;
/*  479 */     _h_ = (int)(_h_ + this.endtime);
/*  480 */     _h_ += this.activityduration;
/*  481 */     _h_ += this.stagemap.hashCode();
/*  482 */     _h_ += this.stage;
/*  483 */     _h_ = (int)(_h_ + this.cleardatatime);
/*  484 */     _h_ += this.openstate;
/*  485 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  491 */     _xdb_verify_unsafe_();
/*  492 */     StringBuilder _sb_ = new StringBuilder();
/*  493 */     _sb_.append("(");
/*  494 */     _sb_.append(this.endtime);
/*  495 */     _sb_.append(",");
/*  496 */     _sb_.append(this.activityduration);
/*  497 */     _sb_.append(",");
/*  498 */     _sb_.append(this.stagemap);
/*  499 */     _sb_.append(",");
/*  500 */     _sb_.append(this.stage);
/*  501 */     _sb_.append(",");
/*  502 */     _sb_.append(this.cleardatatime);
/*  503 */     _sb_.append(",");
/*  504 */     _sb_.append(this.openstate);
/*  505 */     _sb_.append(")");
/*  506 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  512 */     ListenableBean lb = new ListenableBean();
/*  513 */     lb.add(new ListenableChanged().setVarName("endtime"));
/*  514 */     lb.add(new ListenableChanged().setVarName("activityduration"));
/*  515 */     lb.add(new xdb.logs.ListenableMap().setVarName("stagemap"));
/*  516 */     lb.add(new ListenableChanged().setVarName("stage"));
/*  517 */     lb.add(new ListenableChanged().setVarName("cleardatatime"));
/*  518 */     lb.add(new ListenableChanged().setVarName("openstate"));
/*  519 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.OpenBeanStore {
/*      */     private Const() {}
/*      */     
/*      */     OpenBeanStore nThis() {
/*  526 */       return OpenBeanStore.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  532 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OpenBeanStore copy()
/*      */     {
/*  538 */       return OpenBeanStore.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OpenBeanStore toData()
/*      */     {
/*  544 */       return OpenBeanStore.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.OpenBeanStore toBean()
/*      */     {
/*  549 */       return OpenBeanStore.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OpenBeanStore toDataIf()
/*      */     {
/*  555 */       return OpenBeanStore.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.OpenBeanStore toBeanIf()
/*      */     {
/*  560 */       return OpenBeanStore.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/*  567 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  568 */       return OpenBeanStore.this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivityduration()
/*      */     {
/*  575 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  576 */       return OpenBeanStore.this.activityduration;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.StageBean> getStagemap()
/*      */     {
/*  583 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  584 */       return xdb.Consts.constMap(OpenBeanStore.this.stagemap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.StageBean> getStagemapAsData()
/*      */     {
/*  591 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*      */       
/*  593 */       OpenBeanStore _o_ = OpenBeanStore.this;
/*  594 */       Map<Integer, xbean.StageBean> stagemap = new HashMap();
/*  595 */       for (Map.Entry<Integer, xbean.StageBean> _e_ : _o_.stagemap.entrySet())
/*  596 */         stagemap.put(_e_.getKey(), new StageBean.Data((xbean.StageBean)_e_.getValue()));
/*  597 */       return stagemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/*  604 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  605 */       return OpenBeanStore.this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCleardatatime()
/*      */     {
/*  612 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  613 */       return OpenBeanStore.this.cleardatatime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOpenstate()
/*      */     {
/*  620 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  621 */       return OpenBeanStore.this.openstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/*  628 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivityduration(int _v_)
/*      */     {
/*  636 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  637 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/*  644 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  645 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleardatatime(long _v_)
/*      */     {
/*  652 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  653 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpenstate(int _v_)
/*      */     {
/*  660 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  667 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  668 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  674 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  675 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  681 */       return OpenBeanStore.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  687 */       return OpenBeanStore.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  693 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  700 */       return OpenBeanStore.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  706 */       return OpenBeanStore.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  712 */       OpenBeanStore.this._xdb_verify_unsafe_();
/*  713 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  719 */       return OpenBeanStore.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  725 */       return OpenBeanStore.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  731 */       return OpenBeanStore.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  737 */       return OpenBeanStore.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  743 */       return OpenBeanStore.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  749 */       return OpenBeanStore.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  755 */       return OpenBeanStore.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.OpenBeanStore
/*      */   {
/*      */     private long endtime;
/*      */     
/*      */     private int activityduration;
/*      */     
/*      */     private HashMap<Integer, xbean.StageBean> stagemap;
/*      */     
/*      */     private int stage;
/*      */     
/*      */     private long cleardatatime;
/*      */     
/*      */     private int openstate;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  777 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  782 */       this.stagemap = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.OpenBeanStore _o1_)
/*      */     {
/*  787 */       if ((_o1_ instanceof OpenBeanStore)) { assign((OpenBeanStore)_o1_);
/*  788 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  789 */       } else if ((_o1_ instanceof OpenBeanStore.Const)) assign(((OpenBeanStore.Const)_o1_).nThis()); else {
/*  790 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(OpenBeanStore _o_) {
/*  795 */       this.endtime = _o_.endtime;
/*  796 */       this.activityduration = _o_.activityduration;
/*  797 */       this.stagemap = new HashMap();
/*  798 */       for (Map.Entry<Integer, xbean.StageBean> _e_ : _o_.stagemap.entrySet())
/*  799 */         this.stagemap.put(_e_.getKey(), new StageBean.Data((xbean.StageBean)_e_.getValue()));
/*  800 */       this.stage = _o_.stage;
/*  801 */       this.cleardatatime = _o_.cleardatatime;
/*  802 */       this.openstate = _o_.openstate;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  807 */       this.endtime = _o_.endtime;
/*  808 */       this.activityduration = _o_.activityduration;
/*  809 */       this.stagemap = new HashMap();
/*  810 */       for (Map.Entry<Integer, xbean.StageBean> _e_ : _o_.stagemap.entrySet())
/*  811 */         this.stagemap.put(_e_.getKey(), new StageBean.Data((xbean.StageBean)_e_.getValue()));
/*  812 */       this.stage = _o_.stage;
/*  813 */       this.cleardatatime = _o_.cleardatatime;
/*  814 */       this.openstate = _o_.openstate;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  820 */       _os_.marshal(this.endtime);
/*  821 */       _os_.marshal(this.activityduration);
/*  822 */       _os_.compact_uint32(this.stagemap.size());
/*  823 */       for (Map.Entry<Integer, xbean.StageBean> _e_ : this.stagemap.entrySet())
/*      */       {
/*  825 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  826 */         ((xbean.StageBean)_e_.getValue()).marshal(_os_);
/*      */       }
/*  828 */       _os_.marshal(this.stage);
/*  829 */       _os_.marshal(this.cleardatatime);
/*  830 */       _os_.marshal(this.openstate);
/*  831 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  837 */       this.endtime = _os_.unmarshal_long();
/*  838 */       this.activityduration = _os_.unmarshal_int();
/*      */       
/*  840 */       int size = _os_.uncompact_uint32();
/*  841 */       if (size >= 12)
/*      */       {
/*  843 */         this.stagemap = new HashMap(size * 2);
/*      */       }
/*  845 */       for (; size > 0; size--)
/*      */       {
/*  847 */         int _k_ = 0;
/*  848 */         _k_ = _os_.unmarshal_int();
/*  849 */         xbean.StageBean _v_ = xbean.Pod.newStageBeanData();
/*  850 */         _v_.unmarshal(_os_);
/*  851 */         this.stagemap.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  854 */       this.stage = _os_.unmarshal_int();
/*  855 */       this.cleardatatime = _os_.unmarshal_long();
/*  856 */       this.openstate = _os_.unmarshal_int();
/*  857 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  863 */       int _size_ = 0;
/*  864 */       _size_ += CodedOutputStream.computeInt64Size(1, this.endtime);
/*  865 */       _size_ += CodedOutputStream.computeInt32Size(2, this.activityduration);
/*  866 */       for (Map.Entry<Integer, xbean.StageBean> _e_ : this.stagemap.entrySet())
/*      */       {
/*  868 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  869 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  871 */       _size_ += CodedOutputStream.computeInt32Size(4, this.stage);
/*  872 */       _size_ += CodedOutputStream.computeInt64Size(5, this.cleardatatime);
/*  873 */       _size_ += CodedOutputStream.computeInt32Size(6, this.openstate);
/*  874 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  882 */         _output_.writeInt64(1, this.endtime);
/*  883 */         _output_.writeInt32(2, this.activityduration);
/*  884 */         for (Map.Entry<Integer, xbean.StageBean> _e_ : this.stagemap.entrySet())
/*      */         {
/*  886 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  887 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */         }
/*  889 */         _output_.writeInt32(4, this.stage);
/*  890 */         _output_.writeInt64(5, this.cleardatatime);
/*  891 */         _output_.writeInt32(6, this.openstate);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  895 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  897 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  905 */         boolean done = false;
/*  906 */         while (!done)
/*      */         {
/*  908 */           int tag = _input_.readTag();
/*  909 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  913 */             done = true;
/*  914 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  918 */             this.endtime = _input_.readInt64();
/*  919 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  923 */             this.activityduration = _input_.readInt32();
/*  924 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  928 */             int _k_ = 0;
/*  929 */             _k_ = _input_.readInt32();
/*  930 */             int readTag = _input_.readTag();
/*  931 */             if (26 != readTag)
/*      */             {
/*  933 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  935 */             xbean.StageBean _v_ = xbean.Pod.newStageBeanData();
/*  936 */             _input_.readMessage(_v_);
/*  937 */             this.stagemap.put(Integer.valueOf(_k_), _v_);
/*  938 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  942 */             this.stage = _input_.readInt32();
/*  943 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  947 */             this.cleardatatime = _input_.readInt64();
/*  948 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  952 */             this.openstate = _input_.readInt32();
/*  953 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  957 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  959 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  968 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  972 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  974 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OpenBeanStore copy()
/*      */     {
/*  980 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OpenBeanStore toData()
/*      */     {
/*  986 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.OpenBeanStore toBean()
/*      */     {
/*  991 */       return new OpenBeanStore(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.OpenBeanStore toDataIf()
/*      */     {
/*  997 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.OpenBeanStore toBeanIf()
/*      */     {
/* 1002 */       return new OpenBeanStore(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1008 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1012 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1016 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1020 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1024 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1028 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1032 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEndtime()
/*      */     {
/* 1039 */       return this.endtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivityduration()
/*      */     {
/* 1046 */       return this.activityduration;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.StageBean> getStagemap()
/*      */     {
/* 1053 */       return this.stagemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.StageBean> getStagemapAsData()
/*      */     {
/* 1060 */       return this.stagemap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/* 1067 */       return this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCleardatatime()
/*      */     {
/* 1074 */       return this.cleardatatime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getOpenstate()
/*      */     {
/* 1081 */       return this.openstate;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEndtime(long _v_)
/*      */     {
/* 1088 */       this.endtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivityduration(int _v_)
/*      */     {
/* 1095 */       this.activityduration = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/* 1102 */       this.stage = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleardatatime(long _v_)
/*      */     {
/* 1109 */       this.cleardatatime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpenstate(int _v_)
/*      */     {
/* 1116 */       this.openstate = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1122 */       if (!(_o1_ instanceof Data)) return false;
/* 1123 */       Data _o_ = (Data)_o1_;
/* 1124 */       if (this.endtime != _o_.endtime) return false;
/* 1125 */       if (this.activityduration != _o_.activityduration) return false;
/* 1126 */       if (!this.stagemap.equals(_o_.stagemap)) return false;
/* 1127 */       if (this.stage != _o_.stage) return false;
/* 1128 */       if (this.cleardatatime != _o_.cleardatatime) return false;
/* 1129 */       if (this.openstate != _o_.openstate) return false;
/* 1130 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1136 */       int _h_ = 0;
/* 1137 */       _h_ = (int)(_h_ + this.endtime);
/* 1138 */       _h_ += this.activityduration;
/* 1139 */       _h_ += this.stagemap.hashCode();
/* 1140 */       _h_ += this.stage;
/* 1141 */       _h_ = (int)(_h_ + this.cleardatatime);
/* 1142 */       _h_ += this.openstate;
/* 1143 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1149 */       StringBuilder _sb_ = new StringBuilder();
/* 1150 */       _sb_.append("(");
/* 1151 */       _sb_.append(this.endtime);
/* 1152 */       _sb_.append(",");
/* 1153 */       _sb_.append(this.activityduration);
/* 1154 */       _sb_.append(",");
/* 1155 */       _sb_.append(this.stagemap);
/* 1156 */       _sb_.append(",");
/* 1157 */       _sb_.append(this.stage);
/* 1158 */       _sb_.append(",");
/* 1159 */       _sb_.append(this.cleardatatime);
/* 1160 */       _sb_.append(",");
/* 1161 */       _sb_.append(this.openstate);
/* 1162 */       _sb_.append(")");
/* 1163 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\OpenBeanStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */