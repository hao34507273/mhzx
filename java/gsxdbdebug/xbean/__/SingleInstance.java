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
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class SingleInstance extends XBean implements xbean.SingleInstance
/*      */ {
/*      */   private int curprocess;
/*      */   private int highprocess;
/*      */   private int finishtimes;
/*      */   private HashMap<Integer, xbean.ProcessBean> processmap;
/*      */   private int sign;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.curprocess = 1;
/*   27 */     this.highprocess = 0;
/*   28 */     this.finishtimes = 0;
/*   29 */     this.processmap.clear();
/*   30 */     this.sign = 1;
/*      */   }
/*      */   
/*      */   SingleInstance(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.curprocess = 1;
/*   37 */     this.processmap = new HashMap();
/*   38 */     this.sign = 1;
/*      */   }
/*      */   
/*      */   public SingleInstance()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public SingleInstance(SingleInstance _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   SingleInstance(xbean.SingleInstance _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof SingleInstance)) { assign((SingleInstance)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(SingleInstance _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.curprocess = _o_.curprocess;
/*   64 */     this.highprocess = _o_.highprocess;
/*   65 */     this.finishtimes = _o_.finishtimes;
/*   66 */     this.processmap = new HashMap();
/*   67 */     for (Map.Entry<Integer, xbean.ProcessBean> _e_ : _o_.processmap.entrySet())
/*   68 */       this.processmap.put(_e_.getKey(), new ProcessBean((xbean.ProcessBean)_e_.getValue(), this, "processmap"));
/*   69 */     this.sign = _o_.sign;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   74 */     this.curprocess = _o_.curprocess;
/*   75 */     this.highprocess = _o_.highprocess;
/*   76 */     this.finishtimes = _o_.finishtimes;
/*   77 */     this.processmap = new HashMap();
/*   78 */     for (Map.Entry<Integer, xbean.ProcessBean> _e_ : _o_.processmap.entrySet())
/*   79 */       this.processmap.put(_e_.getKey(), new ProcessBean((xbean.ProcessBean)_e_.getValue(), this, "processmap"));
/*   80 */     this.sign = _o_.sign;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   86 */     _xdb_verify_unsafe_();
/*   87 */     _os_.marshal(this.curprocess);
/*   88 */     _os_.marshal(this.highprocess);
/*   89 */     _os_.marshal(this.finishtimes);
/*   90 */     _os_.compact_uint32(this.processmap.size());
/*   91 */     for (Map.Entry<Integer, xbean.ProcessBean> _e_ : this.processmap.entrySet())
/*      */     {
/*   93 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   94 */       ((xbean.ProcessBean)_e_.getValue()).marshal(_os_);
/*      */     }
/*   96 */     _os_.marshal(this.sign);
/*   97 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     this.curprocess = _os_.unmarshal_int();
/*  105 */     this.highprocess = _os_.unmarshal_int();
/*  106 */     this.finishtimes = _os_.unmarshal_int();
/*      */     
/*  108 */     int size = _os_.uncompact_uint32();
/*  109 */     if (size >= 12)
/*      */     {
/*  111 */       this.processmap = new HashMap(size * 2);
/*      */     }
/*  113 */     for (; size > 0; size--)
/*      */     {
/*  115 */       int _k_ = 0;
/*  116 */       _k_ = _os_.unmarshal_int();
/*  117 */       xbean.ProcessBean _v_ = new ProcessBean(0, this, "processmap");
/*  118 */       _v_.unmarshal(_os_);
/*  119 */       this.processmap.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  122 */     this.sign = _os_.unmarshal_int();
/*  123 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  129 */     _xdb_verify_unsafe_();
/*  130 */     int _size_ = 0;
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(1, this.curprocess);
/*  132 */     _size_ += CodedOutputStream.computeInt32Size(2, this.highprocess);
/*  133 */     _size_ += CodedOutputStream.computeInt32Size(3, this.finishtimes);
/*  134 */     for (Map.Entry<Integer, xbean.ProcessBean> _e_ : this.processmap.entrySet())
/*      */     {
/*  136 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  137 */       _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */     }
/*  139 */     _size_ += CodedOutputStream.computeInt32Size(5, this.sign);
/*  140 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  146 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  149 */       _output_.writeInt32(1, this.curprocess);
/*  150 */       _output_.writeInt32(2, this.highprocess);
/*  151 */       _output_.writeInt32(3, this.finishtimes);
/*  152 */       for (Map.Entry<Integer, xbean.ProcessBean> _e_ : this.processmap.entrySet())
/*      */       {
/*  154 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  155 */         _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  157 */       _output_.writeInt32(5, this.sign);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  161 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  163 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  169 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  172 */       boolean done = false;
/*  173 */       while (!done)
/*      */       {
/*  175 */         int tag = _input_.readTag();
/*  176 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  180 */           done = true;
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  185 */           this.curprocess = _input_.readInt32();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  190 */           this.highprocess = _input_.readInt32();
/*  191 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  195 */           this.finishtimes = _input_.readInt32();
/*  196 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  200 */           int _k_ = 0;
/*  201 */           _k_ = _input_.readInt32();
/*  202 */           int readTag = _input_.readTag();
/*  203 */           if (34 != readTag)
/*      */           {
/*  205 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  207 */           xbean.ProcessBean _v_ = new ProcessBean(0, this, "processmap");
/*  208 */           _input_.readMessage(_v_);
/*  209 */           this.processmap.put(Integer.valueOf(_k_), _v_);
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  214 */           this.sign = _input_.readInt32();
/*  215 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  219 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  221 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  230 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  234 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  236 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SingleInstance copy()
/*      */   {
/*  242 */     _xdb_verify_unsafe_();
/*  243 */     return new SingleInstance(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SingleInstance toData()
/*      */   {
/*  249 */     _xdb_verify_unsafe_();
/*  250 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SingleInstance toBean()
/*      */   {
/*  255 */     _xdb_verify_unsafe_();
/*  256 */     return new SingleInstance(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SingleInstance toDataIf()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SingleInstance toBeanIf()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurprocess()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.curprocess;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getHighprocess()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.highprocess;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFinishtimes()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return this.finishtimes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ProcessBean> getProcessmap()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return xdb.Logs.logMap(new LogKey(this, "processmap"), this.processmap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ProcessBean> getProcessmapAsData()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*      */     
/*  317 */     SingleInstance _o_ = this;
/*  318 */     Map<Integer, xbean.ProcessBean> processmap = new HashMap();
/*  319 */     for (Map.Entry<Integer, xbean.ProcessBean> _e_ : _o_.processmap.entrySet())
/*  320 */       processmap.put(_e_.getKey(), new ProcessBean.Data((xbean.ProcessBean)_e_.getValue()));
/*  321 */     return processmap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getSign()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return this.sign;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurprocess(int _v_)
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     xdb.Logs.logIf(new LogKey(this, "curprocess")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  341 */         new LogInt(this, SingleInstance.this.curprocess)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  345 */             SingleInstance.this.curprocess = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  349 */     });
/*  350 */     this.curprocess = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHighprocess(int _v_)
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     xdb.Logs.logIf(new LogKey(this, "highprocess")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  362 */         new LogInt(this, SingleInstance.this.highprocess)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  366 */             SingleInstance.this.highprocess = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  370 */     });
/*  371 */     this.highprocess = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFinishtimes(int _v_)
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     xdb.Logs.logIf(new LogKey(this, "finishtimes")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  383 */         new LogInt(this, SingleInstance.this.finishtimes)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  387 */             SingleInstance.this.finishtimes = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  391 */     });
/*  392 */     this.finishtimes = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSign(int _v_)
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     xdb.Logs.logIf(new LogKey(this, "sign")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  404 */         new LogInt(this, SingleInstance.this.sign)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  408 */             SingleInstance.this.sign = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  412 */     });
/*  413 */     this.sign = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     SingleInstance _o_ = null;
/*  421 */     if ((_o1_ instanceof SingleInstance)) { _o_ = (SingleInstance)_o1_;
/*  422 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  423 */       return false;
/*  424 */     if (this.curprocess != _o_.curprocess) return false;
/*  425 */     if (this.highprocess != _o_.highprocess) return false;
/*  426 */     if (this.finishtimes != _o_.finishtimes) return false;
/*  427 */     if (!this.processmap.equals(_o_.processmap)) return false;
/*  428 */     if (this.sign != _o_.sign) return false;
/*  429 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     int _h_ = 0;
/*  437 */     _h_ += this.curprocess;
/*  438 */     _h_ += this.highprocess;
/*  439 */     _h_ += this.finishtimes;
/*  440 */     _h_ += this.processmap.hashCode();
/*  441 */     _h_ += this.sign;
/*  442 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  448 */     _xdb_verify_unsafe_();
/*  449 */     StringBuilder _sb_ = new StringBuilder();
/*  450 */     _sb_.append("(");
/*  451 */     _sb_.append(this.curprocess);
/*  452 */     _sb_.append(",");
/*  453 */     _sb_.append(this.highprocess);
/*  454 */     _sb_.append(",");
/*  455 */     _sb_.append(this.finishtimes);
/*  456 */     _sb_.append(",");
/*  457 */     _sb_.append(this.processmap);
/*  458 */     _sb_.append(",");
/*  459 */     _sb_.append(this.sign);
/*  460 */     _sb_.append(")");
/*  461 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  467 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  468 */     lb.add(new ListenableChanged().setVarName("curprocess"));
/*  469 */     lb.add(new ListenableChanged().setVarName("highprocess"));
/*  470 */     lb.add(new ListenableChanged().setVarName("finishtimes"));
/*  471 */     lb.add(new xdb.logs.ListenableMap().setVarName("processmap"));
/*  472 */     lb.add(new ListenableChanged().setVarName("sign"));
/*  473 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.SingleInstance {
/*      */     private Const() {}
/*      */     
/*      */     SingleInstance nThis() {
/*  480 */       return SingleInstance.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  486 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SingleInstance copy()
/*      */     {
/*  492 */       return SingleInstance.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SingleInstance toData()
/*      */     {
/*  498 */       return SingleInstance.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.SingleInstance toBean()
/*      */     {
/*  503 */       return SingleInstance.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SingleInstance toDataIf()
/*      */     {
/*  509 */       return SingleInstance.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.SingleInstance toBeanIf()
/*      */     {
/*  514 */       return SingleInstance.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurprocess()
/*      */     {
/*  521 */       SingleInstance.this._xdb_verify_unsafe_();
/*  522 */       return SingleInstance.this.curprocess;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHighprocess()
/*      */     {
/*  529 */       SingleInstance.this._xdb_verify_unsafe_();
/*  530 */       return SingleInstance.this.highprocess;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFinishtimes()
/*      */     {
/*  537 */       SingleInstance.this._xdb_verify_unsafe_();
/*  538 */       return SingleInstance.this.finishtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ProcessBean> getProcessmap()
/*      */     {
/*  545 */       SingleInstance.this._xdb_verify_unsafe_();
/*  546 */       return xdb.Consts.constMap(SingleInstance.this.processmap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ProcessBean> getProcessmapAsData()
/*      */     {
/*  553 */       SingleInstance.this._xdb_verify_unsafe_();
/*      */       
/*  555 */       SingleInstance _o_ = SingleInstance.this;
/*  556 */       Map<Integer, xbean.ProcessBean> processmap = new HashMap();
/*  557 */       for (Map.Entry<Integer, xbean.ProcessBean> _e_ : _o_.processmap.entrySet())
/*  558 */         processmap.put(_e_.getKey(), new ProcessBean.Data((xbean.ProcessBean)_e_.getValue()));
/*  559 */       return processmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSign()
/*      */     {
/*  566 */       SingleInstance.this._xdb_verify_unsafe_();
/*  567 */       return SingleInstance.this.sign;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurprocess(int _v_)
/*      */     {
/*  574 */       SingleInstance.this._xdb_verify_unsafe_();
/*  575 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHighprocess(int _v_)
/*      */     {
/*  582 */       SingleInstance.this._xdb_verify_unsafe_();
/*  583 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinishtimes(int _v_)
/*      */     {
/*  590 */       SingleInstance.this._xdb_verify_unsafe_();
/*  591 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSign(int _v_)
/*      */     {
/*  598 */       SingleInstance.this._xdb_verify_unsafe_();
/*  599 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  605 */       SingleInstance.this._xdb_verify_unsafe_();
/*  606 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  612 */       SingleInstance.this._xdb_verify_unsafe_();
/*  613 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  619 */       return SingleInstance.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  625 */       return SingleInstance.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  631 */       SingleInstance.this._xdb_verify_unsafe_();
/*  632 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  638 */       return SingleInstance.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  644 */       return SingleInstance.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  650 */       SingleInstance.this._xdb_verify_unsafe_();
/*  651 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  657 */       return SingleInstance.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  663 */       return SingleInstance.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  669 */       return SingleInstance.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  675 */       return SingleInstance.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  681 */       return SingleInstance.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  687 */       return SingleInstance.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  693 */       return SingleInstance.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.SingleInstance
/*      */   {
/*      */     private int curprocess;
/*      */     
/*      */     private int highprocess;
/*      */     
/*      */     private int finishtimes;
/*      */     
/*      */     private HashMap<Integer, xbean.ProcessBean> processmap;
/*      */     
/*      */     private int sign;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  713 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  718 */       this.curprocess = 1;
/*  719 */       this.processmap = new HashMap();
/*  720 */       this.sign = 1;
/*      */     }
/*      */     
/*      */     Data(xbean.SingleInstance _o1_)
/*      */     {
/*  725 */       if ((_o1_ instanceof SingleInstance)) { assign((SingleInstance)_o1_);
/*  726 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  727 */       } else if ((_o1_ instanceof SingleInstance.Const)) assign(((SingleInstance.Const)_o1_).nThis()); else {
/*  728 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(SingleInstance _o_) {
/*  733 */       this.curprocess = _o_.curprocess;
/*  734 */       this.highprocess = _o_.highprocess;
/*  735 */       this.finishtimes = _o_.finishtimes;
/*  736 */       this.processmap = new HashMap();
/*  737 */       for (Map.Entry<Integer, xbean.ProcessBean> _e_ : _o_.processmap.entrySet())
/*  738 */         this.processmap.put(_e_.getKey(), new ProcessBean.Data((xbean.ProcessBean)_e_.getValue()));
/*  739 */       this.sign = _o_.sign;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  744 */       this.curprocess = _o_.curprocess;
/*  745 */       this.highprocess = _o_.highprocess;
/*  746 */       this.finishtimes = _o_.finishtimes;
/*  747 */       this.processmap = new HashMap();
/*  748 */       for (Map.Entry<Integer, xbean.ProcessBean> _e_ : _o_.processmap.entrySet())
/*  749 */         this.processmap.put(_e_.getKey(), new ProcessBean.Data((xbean.ProcessBean)_e_.getValue()));
/*  750 */       this.sign = _o_.sign;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  756 */       _os_.marshal(this.curprocess);
/*  757 */       _os_.marshal(this.highprocess);
/*  758 */       _os_.marshal(this.finishtimes);
/*  759 */       _os_.compact_uint32(this.processmap.size());
/*  760 */       for (Map.Entry<Integer, xbean.ProcessBean> _e_ : this.processmap.entrySet())
/*      */       {
/*  762 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  763 */         ((xbean.ProcessBean)_e_.getValue()).marshal(_os_);
/*      */       }
/*  765 */       _os_.marshal(this.sign);
/*  766 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  772 */       this.curprocess = _os_.unmarshal_int();
/*  773 */       this.highprocess = _os_.unmarshal_int();
/*  774 */       this.finishtimes = _os_.unmarshal_int();
/*      */       
/*  776 */       int size = _os_.uncompact_uint32();
/*  777 */       if (size >= 12)
/*      */       {
/*  779 */         this.processmap = new HashMap(size * 2);
/*      */       }
/*  781 */       for (; size > 0; size--)
/*      */       {
/*  783 */         int _k_ = 0;
/*  784 */         _k_ = _os_.unmarshal_int();
/*  785 */         xbean.ProcessBean _v_ = xbean.Pod.newProcessBeanData();
/*  786 */         _v_.unmarshal(_os_);
/*  787 */         this.processmap.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  790 */       this.sign = _os_.unmarshal_int();
/*  791 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  797 */       int _size_ = 0;
/*  798 */       _size_ += CodedOutputStream.computeInt32Size(1, this.curprocess);
/*  799 */       _size_ += CodedOutputStream.computeInt32Size(2, this.highprocess);
/*  800 */       _size_ += CodedOutputStream.computeInt32Size(3, this.finishtimes);
/*  801 */       for (Map.Entry<Integer, xbean.ProcessBean> _e_ : this.processmap.entrySet())
/*      */       {
/*  803 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  804 */         _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  806 */       _size_ += CodedOutputStream.computeInt32Size(5, this.sign);
/*  807 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  815 */         _output_.writeInt32(1, this.curprocess);
/*  816 */         _output_.writeInt32(2, this.highprocess);
/*  817 */         _output_.writeInt32(3, this.finishtimes);
/*  818 */         for (Map.Entry<Integer, xbean.ProcessBean> _e_ : this.processmap.entrySet())
/*      */         {
/*  820 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  821 */           _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */         }
/*  823 */         _output_.writeInt32(5, this.sign);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  827 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  829 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  837 */         boolean done = false;
/*  838 */         while (!done)
/*      */         {
/*  840 */           int tag = _input_.readTag();
/*  841 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  845 */             done = true;
/*  846 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  850 */             this.curprocess = _input_.readInt32();
/*  851 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  855 */             this.highprocess = _input_.readInt32();
/*  856 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  860 */             this.finishtimes = _input_.readInt32();
/*  861 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  865 */             int _k_ = 0;
/*  866 */             _k_ = _input_.readInt32();
/*  867 */             int readTag = _input_.readTag();
/*  868 */             if (34 != readTag)
/*      */             {
/*  870 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  872 */             xbean.ProcessBean _v_ = xbean.Pod.newProcessBeanData();
/*  873 */             _input_.readMessage(_v_);
/*  874 */             this.processmap.put(Integer.valueOf(_k_), _v_);
/*  875 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  879 */             this.sign = _input_.readInt32();
/*  880 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  884 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  886 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  895 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  899 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  901 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SingleInstance copy()
/*      */     {
/*  907 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SingleInstance toData()
/*      */     {
/*  913 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.SingleInstance toBean()
/*      */     {
/*  918 */       return new SingleInstance(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SingleInstance toDataIf()
/*      */     {
/*  924 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.SingleInstance toBeanIf()
/*      */     {
/*  929 */       return new SingleInstance(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  935 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  955 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  959 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurprocess()
/*      */     {
/*  966 */       return this.curprocess;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getHighprocess()
/*      */     {
/*  973 */       return this.highprocess;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFinishtimes()
/*      */     {
/*  980 */       return this.finishtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ProcessBean> getProcessmap()
/*      */     {
/*  987 */       return this.processmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ProcessBean> getProcessmapAsData()
/*      */     {
/*  994 */       return this.processmap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getSign()
/*      */     {
/* 1001 */       return this.sign;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurprocess(int _v_)
/*      */     {
/* 1008 */       this.curprocess = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHighprocess(int _v_)
/*      */     {
/* 1015 */       this.highprocess = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinishtimes(int _v_)
/*      */     {
/* 1022 */       this.finishtimes = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSign(int _v_)
/*      */     {
/* 1029 */       this.sign = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1035 */       if (!(_o1_ instanceof Data)) return false;
/* 1036 */       Data _o_ = (Data)_o1_;
/* 1037 */       if (this.curprocess != _o_.curprocess) return false;
/* 1038 */       if (this.highprocess != _o_.highprocess) return false;
/* 1039 */       if (this.finishtimes != _o_.finishtimes) return false;
/* 1040 */       if (!this.processmap.equals(_o_.processmap)) return false;
/* 1041 */       if (this.sign != _o_.sign) return false;
/* 1042 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1048 */       int _h_ = 0;
/* 1049 */       _h_ += this.curprocess;
/* 1050 */       _h_ += this.highprocess;
/* 1051 */       _h_ += this.finishtimes;
/* 1052 */       _h_ += this.processmap.hashCode();
/* 1053 */       _h_ += this.sign;
/* 1054 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1060 */       StringBuilder _sb_ = new StringBuilder();
/* 1061 */       _sb_.append("(");
/* 1062 */       _sb_.append(this.curprocess);
/* 1063 */       _sb_.append(",");
/* 1064 */       _sb_.append(this.highprocess);
/* 1065 */       _sb_.append(",");
/* 1066 */       _sb_.append(this.finishtimes);
/* 1067 */       _sb_.append(",");
/* 1068 */       _sb_.append(this.processmap);
/* 1069 */       _sb_.append(",");
/* 1070 */       _sb_.append(this.sign);
/* 1071 */       _sb_.append(")");
/* 1072 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SingleInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */