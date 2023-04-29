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
/*      */ public final class BountyInfo extends XBean implements xbean.BountyInfo
/*      */ {
/*      */   private int bountycount;
/*      */   private HashMap<Integer, xbean.BTaskInfo> taskinfos;
/*      */   private HashMap<Integer, xbean.BTaskData> donetaskinfo;
/*      */   private int usedbirdnum;
/*      */   private int freerefreshcount;
/*      */   private int preguaranteecount;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.bountycount = 0;
/*   29 */     this.taskinfos.clear();
/*   30 */     this.donetaskinfo.clear();
/*   31 */     this.usedbirdnum = 0;
/*   32 */     this.freerefreshcount = 0;
/*   33 */     this.preguaranteecount = 0;
/*      */   }
/*      */   
/*      */   BountyInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.taskinfos = new HashMap();
/*   40 */     this.donetaskinfo = new HashMap();
/*      */   }
/*      */   
/*      */   public BountyInfo()
/*      */   {
/*   45 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BountyInfo(BountyInfo _o_)
/*      */   {
/*   50 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BountyInfo(xbean.BountyInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   55 */     super(_xp_, _vn_);
/*   56 */     if ((_o1_ instanceof BountyInfo)) { assign((BountyInfo)_o1_);
/*   57 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   58 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   59 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BountyInfo _o_) {
/*   64 */     _o_._xdb_verify_unsafe_();
/*   65 */     this.bountycount = _o_.bountycount;
/*   66 */     this.taskinfos = new HashMap();
/*   67 */     for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : _o_.taskinfos.entrySet())
/*   68 */       this.taskinfos.put(_e_.getKey(), new BTaskInfo((xbean.BTaskInfo)_e_.getValue(), this, "taskinfos"));
/*   69 */     this.donetaskinfo = new HashMap();
/*   70 */     for (Map.Entry<Integer, xbean.BTaskData> _e_ : _o_.donetaskinfo.entrySet())
/*   71 */       this.donetaskinfo.put(_e_.getKey(), new BTaskData((xbean.BTaskData)_e_.getValue(), this, "donetaskinfo"));
/*   72 */     this.usedbirdnum = _o_.usedbirdnum;
/*   73 */     this.freerefreshcount = _o_.freerefreshcount;
/*   74 */     this.preguaranteecount = _o_.preguaranteecount;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.bountycount = _o_.bountycount;
/*   80 */     this.taskinfos = new HashMap();
/*   81 */     for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : _o_.taskinfos.entrySet())
/*   82 */       this.taskinfos.put(_e_.getKey(), new BTaskInfo((xbean.BTaskInfo)_e_.getValue(), this, "taskinfos"));
/*   83 */     this.donetaskinfo = new HashMap();
/*   84 */     for (Map.Entry<Integer, xbean.BTaskData> _e_ : _o_.donetaskinfo.entrySet())
/*   85 */       this.donetaskinfo.put(_e_.getKey(), new BTaskData((xbean.BTaskData)_e_.getValue(), this, "donetaskinfo"));
/*   86 */     this.usedbirdnum = _o_.usedbirdnum;
/*   87 */     this.freerefreshcount = _o_.freerefreshcount;
/*   88 */     this.preguaranteecount = _o_.preguaranteecount;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   94 */     _xdb_verify_unsafe_();
/*   95 */     _os_.marshal(this.bountycount);
/*   96 */     _os_.compact_uint32(this.taskinfos.size());
/*   97 */     for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : this.taskinfos.entrySet())
/*      */     {
/*   99 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  100 */       ((xbean.BTaskInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  102 */     _os_.compact_uint32(this.donetaskinfo.size());
/*  103 */     for (Map.Entry<Integer, xbean.BTaskData> _e_ : this.donetaskinfo.entrySet())
/*      */     {
/*  105 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  106 */       ((xbean.BTaskData)_e_.getValue()).marshal(_os_);
/*      */     }
/*  108 */     _os_.marshal(this.usedbirdnum);
/*  109 */     _os_.marshal(this.freerefreshcount);
/*  110 */     _os_.marshal(this.preguaranteecount);
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     this.bountycount = _os_.unmarshal_int();
/*      */     
/*  120 */     int size = _os_.uncompact_uint32();
/*  121 */     if (size >= 12)
/*      */     {
/*  123 */       this.taskinfos = new HashMap(size * 2);
/*      */     }
/*  125 */     for (; size > 0; size--)
/*      */     {
/*  127 */       int _k_ = 0;
/*  128 */       _k_ = _os_.unmarshal_int();
/*  129 */       xbean.BTaskInfo _v_ = new BTaskInfo(0, this, "taskinfos");
/*  130 */       _v_.unmarshal(_os_);
/*  131 */       this.taskinfos.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  135 */     int size = _os_.uncompact_uint32();
/*  136 */     if (size >= 12)
/*      */     {
/*  138 */       this.donetaskinfo = new HashMap(size * 2);
/*      */     }
/*  140 */     for (; size > 0; size--)
/*      */     {
/*  142 */       int _k_ = 0;
/*  143 */       _k_ = _os_.unmarshal_int();
/*  144 */       xbean.BTaskData _v_ = new BTaskData(0, this, "donetaskinfo");
/*  145 */       _v_.unmarshal(_os_);
/*  146 */       this.donetaskinfo.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  149 */     this.usedbirdnum = _os_.unmarshal_int();
/*  150 */     this.freerefreshcount = _os_.unmarshal_int();
/*  151 */     this.preguaranteecount = _os_.unmarshal_int();
/*  152 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  158 */     _xdb_verify_unsafe_();
/*  159 */     int _size_ = 0;
/*  160 */     _size_ += CodedOutputStream.computeInt32Size(1, this.bountycount);
/*  161 */     for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : this.taskinfos.entrySet())
/*      */     {
/*  163 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  164 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  166 */     for (Map.Entry<Integer, xbean.BTaskData> _e_ : this.donetaskinfo.entrySet())
/*      */     {
/*  168 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  169 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */     }
/*  171 */     _size_ += CodedOutputStream.computeInt32Size(4, this.usedbirdnum);
/*  172 */     _size_ += CodedOutputStream.computeInt32Size(5, this.freerefreshcount);
/*  173 */     _size_ += CodedOutputStream.computeInt32Size(6, this.preguaranteecount);
/*  174 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       _output_.writeInt32(1, this.bountycount);
/*  184 */       for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : this.taskinfos.entrySet())
/*      */       {
/*  186 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  187 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  189 */       for (Map.Entry<Integer, xbean.BTaskData> _e_ : this.donetaskinfo.entrySet())
/*      */       {
/*  191 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  192 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  194 */       _output_.writeInt32(4, this.usedbirdnum);
/*  195 */       _output_.writeInt32(5, this.freerefreshcount);
/*  196 */       _output_.writeInt32(6, this.preguaranteecount);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  200 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  202 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  211 */       boolean done = false;
/*  212 */       while (!done)
/*      */       {
/*  214 */         int tag = _input_.readTag();
/*  215 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  219 */           done = true;
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  224 */           this.bountycount = _input_.readInt32();
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  229 */           int _k_ = 0;
/*  230 */           _k_ = _input_.readInt32();
/*  231 */           int readTag = _input_.readTag();
/*  232 */           if (18 != readTag)
/*      */           {
/*  234 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  236 */           xbean.BTaskInfo _v_ = new BTaskInfo(0, this, "taskinfos");
/*  237 */           _input_.readMessage(_v_);
/*  238 */           this.taskinfos.put(Integer.valueOf(_k_), _v_);
/*  239 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  243 */           int _k_ = 0;
/*  244 */           _k_ = _input_.readInt32();
/*  245 */           int readTag = _input_.readTag();
/*  246 */           if (26 != readTag)
/*      */           {
/*  248 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  250 */           xbean.BTaskData _v_ = new BTaskData(0, this, "donetaskinfo");
/*  251 */           _input_.readMessage(_v_);
/*  252 */           this.donetaskinfo.put(Integer.valueOf(_k_), _v_);
/*  253 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  257 */           this.usedbirdnum = _input_.readInt32();
/*  258 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  262 */           this.freerefreshcount = _input_.readInt32();
/*  263 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  267 */           this.preguaranteecount = _input_.readInt32();
/*  268 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  272 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  274 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  283 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  287 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  289 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BountyInfo copy()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new BountyInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BountyInfo toData()
/*      */   {
/*  302 */     _xdb_verify_unsafe_();
/*  303 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BountyInfo toBean()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return new BountyInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BountyInfo toDataIf()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BountyInfo toBeanIf()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBountycount()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return this.bountycount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BTaskInfo> getTaskinfos()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return xdb.Logs.logMap(new LogKey(this, "taskinfos"), this.taskinfos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BTaskInfo> getTaskinfosAsData()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*      */     
/*  354 */     BountyInfo _o_ = this;
/*  355 */     Map<Integer, xbean.BTaskInfo> taskinfos = new HashMap();
/*  356 */     for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : _o_.taskinfos.entrySet())
/*  357 */       taskinfos.put(_e_.getKey(), new BTaskInfo.Data((xbean.BTaskInfo)_e_.getValue()));
/*  358 */     return taskinfos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BTaskData> getDonetaskinfo()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     return xdb.Logs.logMap(new LogKey(this, "donetaskinfo"), this.donetaskinfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.BTaskData> getDonetaskinfoAsData()
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*      */     
/*  375 */     BountyInfo _o_ = this;
/*  376 */     Map<Integer, xbean.BTaskData> donetaskinfo = new HashMap();
/*  377 */     for (Map.Entry<Integer, xbean.BTaskData> _e_ : _o_.donetaskinfo.entrySet())
/*  378 */       donetaskinfo.put(_e_.getKey(), new BTaskData.Data((xbean.BTaskData)_e_.getValue()));
/*  379 */     return donetaskinfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getUsedbirdnum()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     return this.usedbirdnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFreerefreshcount()
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     return this.freerefreshcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPreguaranteecount()
/*      */   {
/*  402 */     _xdb_verify_unsafe_();
/*  403 */     return this.preguaranteecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBountycount(int _v_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     xdb.Logs.logIf(new LogKey(this, "bountycount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  415 */         new LogInt(this, BountyInfo.this.bountycount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  419 */             BountyInfo.this.bountycount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  423 */     });
/*  424 */     this.bountycount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setUsedbirdnum(int _v_)
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     xdb.Logs.logIf(new LogKey(this, "usedbirdnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  436 */         new LogInt(this, BountyInfo.this.usedbirdnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  440 */             BountyInfo.this.usedbirdnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  444 */     });
/*  445 */     this.usedbirdnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFreerefreshcount(int _v_)
/*      */   {
/*  452 */     _xdb_verify_unsafe_();
/*  453 */     xdb.Logs.logIf(new LogKey(this, "freerefreshcount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  457 */         new LogInt(this, BountyInfo.this.freerefreshcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  461 */             BountyInfo.this.freerefreshcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  465 */     });
/*  466 */     this.freerefreshcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPreguaranteecount(int _v_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     xdb.Logs.logIf(new LogKey(this, "preguaranteecount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  478 */         new LogInt(this, BountyInfo.this.preguaranteecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  482 */             BountyInfo.this.preguaranteecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  486 */     });
/*  487 */     this.preguaranteecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     BountyInfo _o_ = null;
/*  495 */     if ((_o1_ instanceof BountyInfo)) { _o_ = (BountyInfo)_o1_;
/*  496 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  497 */       return false;
/*  498 */     if (this.bountycount != _o_.bountycount) return false;
/*  499 */     if (!this.taskinfos.equals(_o_.taskinfos)) return false;
/*  500 */     if (!this.donetaskinfo.equals(_o_.donetaskinfo)) return false;
/*  501 */     if (this.usedbirdnum != _o_.usedbirdnum) return false;
/*  502 */     if (this.freerefreshcount != _o_.freerefreshcount) return false;
/*  503 */     if (this.preguaranteecount != _o_.preguaranteecount) return false;
/*  504 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     int _h_ = 0;
/*  512 */     _h_ += this.bountycount;
/*  513 */     _h_ += this.taskinfos.hashCode();
/*  514 */     _h_ += this.donetaskinfo.hashCode();
/*  515 */     _h_ += this.usedbirdnum;
/*  516 */     _h_ += this.freerefreshcount;
/*  517 */     _h_ += this.preguaranteecount;
/*  518 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  524 */     _xdb_verify_unsafe_();
/*  525 */     StringBuilder _sb_ = new StringBuilder();
/*  526 */     _sb_.append("(");
/*  527 */     _sb_.append(this.bountycount);
/*  528 */     _sb_.append(",");
/*  529 */     _sb_.append(this.taskinfos);
/*  530 */     _sb_.append(",");
/*  531 */     _sb_.append(this.donetaskinfo);
/*  532 */     _sb_.append(",");
/*  533 */     _sb_.append(this.usedbirdnum);
/*  534 */     _sb_.append(",");
/*  535 */     _sb_.append(this.freerefreshcount);
/*  536 */     _sb_.append(",");
/*  537 */     _sb_.append(this.preguaranteecount);
/*  538 */     _sb_.append(")");
/*  539 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  545 */     ListenableBean lb = new ListenableBean();
/*  546 */     lb.add(new ListenableChanged().setVarName("bountycount"));
/*  547 */     lb.add(new xdb.logs.ListenableMap().setVarName("taskinfos"));
/*  548 */     lb.add(new xdb.logs.ListenableMap().setVarName("donetaskinfo"));
/*  549 */     lb.add(new ListenableChanged().setVarName("usedbirdnum"));
/*  550 */     lb.add(new ListenableChanged().setVarName("freerefreshcount"));
/*  551 */     lb.add(new ListenableChanged().setVarName("preguaranteecount"));
/*  552 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BountyInfo {
/*      */     private Const() {}
/*      */     
/*      */     BountyInfo nThis() {
/*  559 */       return BountyInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  565 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BountyInfo copy()
/*      */     {
/*  571 */       return BountyInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BountyInfo toData()
/*      */     {
/*  577 */       return BountyInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BountyInfo toBean()
/*      */     {
/*  582 */       return BountyInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BountyInfo toDataIf()
/*      */     {
/*  588 */       return BountyInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BountyInfo toBeanIf()
/*      */     {
/*  593 */       return BountyInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBountycount()
/*      */     {
/*  600 */       BountyInfo.this._xdb_verify_unsafe_();
/*  601 */       return BountyInfo.this.bountycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BTaskInfo> getTaskinfos()
/*      */     {
/*  608 */       BountyInfo.this._xdb_verify_unsafe_();
/*  609 */       return xdb.Consts.constMap(BountyInfo.this.taskinfos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BTaskInfo> getTaskinfosAsData()
/*      */     {
/*  616 */       BountyInfo.this._xdb_verify_unsafe_();
/*      */       
/*  618 */       BountyInfo _o_ = BountyInfo.this;
/*  619 */       Map<Integer, xbean.BTaskInfo> taskinfos = new HashMap();
/*  620 */       for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : _o_.taskinfos.entrySet())
/*  621 */         taskinfos.put(_e_.getKey(), new BTaskInfo.Data((xbean.BTaskInfo)_e_.getValue()));
/*  622 */       return taskinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BTaskData> getDonetaskinfo()
/*      */     {
/*  629 */       BountyInfo.this._xdb_verify_unsafe_();
/*  630 */       return xdb.Consts.constMap(BountyInfo.this.donetaskinfo);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BTaskData> getDonetaskinfoAsData()
/*      */     {
/*  637 */       BountyInfo.this._xdb_verify_unsafe_();
/*      */       
/*  639 */       BountyInfo _o_ = BountyInfo.this;
/*  640 */       Map<Integer, xbean.BTaskData> donetaskinfo = new HashMap();
/*  641 */       for (Map.Entry<Integer, xbean.BTaskData> _e_ : _o_.donetaskinfo.entrySet())
/*  642 */         donetaskinfo.put(_e_.getKey(), new BTaskData.Data((xbean.BTaskData)_e_.getValue()));
/*  643 */       return donetaskinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUsedbirdnum()
/*      */     {
/*  650 */       BountyInfo.this._xdb_verify_unsafe_();
/*  651 */       return BountyInfo.this.usedbirdnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFreerefreshcount()
/*      */     {
/*  658 */       BountyInfo.this._xdb_verify_unsafe_();
/*  659 */       return BountyInfo.this.freerefreshcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPreguaranteecount()
/*      */     {
/*  666 */       BountyInfo.this._xdb_verify_unsafe_();
/*  667 */       return BountyInfo.this.preguaranteecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBountycount(int _v_)
/*      */     {
/*  674 */       BountyInfo.this._xdb_verify_unsafe_();
/*  675 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUsedbirdnum(int _v_)
/*      */     {
/*  682 */       BountyInfo.this._xdb_verify_unsafe_();
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFreerefreshcount(int _v_)
/*      */     {
/*  690 */       BountyInfo.this._xdb_verify_unsafe_();
/*  691 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPreguaranteecount(int _v_)
/*      */     {
/*  698 */       BountyInfo.this._xdb_verify_unsafe_();
/*  699 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  705 */       BountyInfo.this._xdb_verify_unsafe_();
/*  706 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  712 */       BountyInfo.this._xdb_verify_unsafe_();
/*  713 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  719 */       return BountyInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  725 */       return BountyInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  731 */       BountyInfo.this._xdb_verify_unsafe_();
/*  732 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  738 */       return BountyInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  744 */       return BountyInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  750 */       BountyInfo.this._xdb_verify_unsafe_();
/*  751 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  757 */       return BountyInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  763 */       return BountyInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  769 */       return BountyInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  775 */       return BountyInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  781 */       return BountyInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  787 */       return BountyInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  793 */       return BountyInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BountyInfo
/*      */   {
/*      */     private int bountycount;
/*      */     
/*      */     private HashMap<Integer, xbean.BTaskInfo> taskinfos;
/*      */     
/*      */     private HashMap<Integer, xbean.BTaskData> donetaskinfo;
/*      */     
/*      */     private int usedbirdnum;
/*      */     
/*      */     private int freerefreshcount;
/*      */     
/*      */     private int preguaranteecount;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  815 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  820 */       this.taskinfos = new HashMap();
/*  821 */       this.donetaskinfo = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.BountyInfo _o1_)
/*      */     {
/*  826 */       if ((_o1_ instanceof BountyInfo)) { assign((BountyInfo)_o1_);
/*  827 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  828 */       } else if ((_o1_ instanceof BountyInfo.Const)) assign(((BountyInfo.Const)_o1_).nThis()); else {
/*  829 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BountyInfo _o_) {
/*  834 */       this.bountycount = _o_.bountycount;
/*  835 */       this.taskinfos = new HashMap();
/*  836 */       for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : _o_.taskinfos.entrySet())
/*  837 */         this.taskinfos.put(_e_.getKey(), new BTaskInfo.Data((xbean.BTaskInfo)_e_.getValue()));
/*  838 */       this.donetaskinfo = new HashMap();
/*  839 */       for (Map.Entry<Integer, xbean.BTaskData> _e_ : _o_.donetaskinfo.entrySet())
/*  840 */         this.donetaskinfo.put(_e_.getKey(), new BTaskData.Data((xbean.BTaskData)_e_.getValue()));
/*  841 */       this.usedbirdnum = _o_.usedbirdnum;
/*  842 */       this.freerefreshcount = _o_.freerefreshcount;
/*  843 */       this.preguaranteecount = _o_.preguaranteecount;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  848 */       this.bountycount = _o_.bountycount;
/*  849 */       this.taskinfos = new HashMap();
/*  850 */       for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : _o_.taskinfos.entrySet())
/*  851 */         this.taskinfos.put(_e_.getKey(), new BTaskInfo.Data((xbean.BTaskInfo)_e_.getValue()));
/*  852 */       this.donetaskinfo = new HashMap();
/*  853 */       for (Map.Entry<Integer, xbean.BTaskData> _e_ : _o_.donetaskinfo.entrySet())
/*  854 */         this.donetaskinfo.put(_e_.getKey(), new BTaskData.Data((xbean.BTaskData)_e_.getValue()));
/*  855 */       this.usedbirdnum = _o_.usedbirdnum;
/*  856 */       this.freerefreshcount = _o_.freerefreshcount;
/*  857 */       this.preguaranteecount = _o_.preguaranteecount;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  863 */       _os_.marshal(this.bountycount);
/*  864 */       _os_.compact_uint32(this.taskinfos.size());
/*  865 */       for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : this.taskinfos.entrySet())
/*      */       {
/*  867 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  868 */         ((xbean.BTaskInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  870 */       _os_.compact_uint32(this.donetaskinfo.size());
/*  871 */       for (Map.Entry<Integer, xbean.BTaskData> _e_ : this.donetaskinfo.entrySet())
/*      */       {
/*  873 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  874 */         ((xbean.BTaskData)_e_.getValue()).marshal(_os_);
/*      */       }
/*  876 */       _os_.marshal(this.usedbirdnum);
/*  877 */       _os_.marshal(this.freerefreshcount);
/*  878 */       _os_.marshal(this.preguaranteecount);
/*  879 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  885 */       this.bountycount = _os_.unmarshal_int();
/*      */       
/*  887 */       int size = _os_.uncompact_uint32();
/*  888 */       if (size >= 12)
/*      */       {
/*  890 */         this.taskinfos = new HashMap(size * 2);
/*      */       }
/*  892 */       for (; size > 0; size--)
/*      */       {
/*  894 */         int _k_ = 0;
/*  895 */         _k_ = _os_.unmarshal_int();
/*  896 */         xbean.BTaskInfo _v_ = xbean.Pod.newBTaskInfoData();
/*  897 */         _v_.unmarshal(_os_);
/*  898 */         this.taskinfos.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  902 */       int size = _os_.uncompact_uint32();
/*  903 */       if (size >= 12)
/*      */       {
/*  905 */         this.donetaskinfo = new HashMap(size * 2);
/*      */       }
/*  907 */       for (; size > 0; size--)
/*      */       {
/*  909 */         int _k_ = 0;
/*  910 */         _k_ = _os_.unmarshal_int();
/*  911 */         xbean.BTaskData _v_ = xbean.Pod.newBTaskDataData();
/*  912 */         _v_.unmarshal(_os_);
/*  913 */         this.donetaskinfo.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  916 */       this.usedbirdnum = _os_.unmarshal_int();
/*  917 */       this.freerefreshcount = _os_.unmarshal_int();
/*  918 */       this.preguaranteecount = _os_.unmarshal_int();
/*  919 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  925 */       int _size_ = 0;
/*  926 */       _size_ += CodedOutputStream.computeInt32Size(1, this.bountycount);
/*  927 */       for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : this.taskinfos.entrySet())
/*      */       {
/*  929 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  930 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  932 */       for (Map.Entry<Integer, xbean.BTaskData> _e_ : this.donetaskinfo.entrySet())
/*      */       {
/*  934 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  935 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  937 */       _size_ += CodedOutputStream.computeInt32Size(4, this.usedbirdnum);
/*  938 */       _size_ += CodedOutputStream.computeInt32Size(5, this.freerefreshcount);
/*  939 */       _size_ += CodedOutputStream.computeInt32Size(6, this.preguaranteecount);
/*  940 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  948 */         _output_.writeInt32(1, this.bountycount);
/*  949 */         for (Map.Entry<Integer, xbean.BTaskInfo> _e_ : this.taskinfos.entrySet())
/*      */         {
/*  951 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  952 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/*  954 */         for (Map.Entry<Integer, xbean.BTaskData> _e_ : this.donetaskinfo.entrySet())
/*      */         {
/*  956 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  957 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */         }
/*  959 */         _output_.writeInt32(4, this.usedbirdnum);
/*  960 */         _output_.writeInt32(5, this.freerefreshcount);
/*  961 */         _output_.writeInt32(6, this.preguaranteecount);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  965 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  967 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  975 */         boolean done = false;
/*  976 */         while (!done)
/*      */         {
/*  978 */           int tag = _input_.readTag();
/*  979 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  983 */             done = true;
/*  984 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  988 */             this.bountycount = _input_.readInt32();
/*  989 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  993 */             int _k_ = 0;
/*  994 */             _k_ = _input_.readInt32();
/*  995 */             int readTag = _input_.readTag();
/*  996 */             if (18 != readTag)
/*      */             {
/*  998 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1000 */             xbean.BTaskInfo _v_ = xbean.Pod.newBTaskInfoData();
/* 1001 */             _input_.readMessage(_v_);
/* 1002 */             this.taskinfos.put(Integer.valueOf(_k_), _v_);
/* 1003 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1007 */             int _k_ = 0;
/* 1008 */             _k_ = _input_.readInt32();
/* 1009 */             int readTag = _input_.readTag();
/* 1010 */             if (26 != readTag)
/*      */             {
/* 1012 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1014 */             xbean.BTaskData _v_ = xbean.Pod.newBTaskDataData();
/* 1015 */             _input_.readMessage(_v_);
/* 1016 */             this.donetaskinfo.put(Integer.valueOf(_k_), _v_);
/* 1017 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1021 */             this.usedbirdnum = _input_.readInt32();
/* 1022 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1026 */             this.freerefreshcount = _input_.readInt32();
/* 1027 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1031 */             this.preguaranteecount = _input_.readInt32();
/* 1032 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1036 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1038 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1047 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1051 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1053 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BountyInfo copy()
/*      */     {
/* 1059 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BountyInfo toData()
/*      */     {
/* 1065 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BountyInfo toBean()
/*      */     {
/* 1070 */       return new BountyInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BountyInfo toDataIf()
/*      */     {
/* 1076 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BountyInfo toBeanIf()
/*      */     {
/* 1081 */       return new BountyInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1087 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1091 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1095 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1099 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1103 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1107 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1111 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBountycount()
/*      */     {
/* 1118 */       return this.bountycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BTaskInfo> getTaskinfos()
/*      */     {
/* 1125 */       return this.taskinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BTaskInfo> getTaskinfosAsData()
/*      */     {
/* 1132 */       return this.taskinfos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BTaskData> getDonetaskinfo()
/*      */     {
/* 1139 */       return this.donetaskinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.BTaskData> getDonetaskinfoAsData()
/*      */     {
/* 1146 */       return this.donetaskinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getUsedbirdnum()
/*      */     {
/* 1153 */       return this.usedbirdnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFreerefreshcount()
/*      */     {
/* 1160 */       return this.freerefreshcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPreguaranteecount()
/*      */     {
/* 1167 */       return this.preguaranteecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBountycount(int _v_)
/*      */     {
/* 1174 */       this.bountycount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setUsedbirdnum(int _v_)
/*      */     {
/* 1181 */       this.usedbirdnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFreerefreshcount(int _v_)
/*      */     {
/* 1188 */       this.freerefreshcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPreguaranteecount(int _v_)
/*      */     {
/* 1195 */       this.preguaranteecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1201 */       if (!(_o1_ instanceof Data)) return false;
/* 1202 */       Data _o_ = (Data)_o1_;
/* 1203 */       if (this.bountycount != _o_.bountycount) return false;
/* 1204 */       if (!this.taskinfos.equals(_o_.taskinfos)) return false;
/* 1205 */       if (!this.donetaskinfo.equals(_o_.donetaskinfo)) return false;
/* 1206 */       if (this.usedbirdnum != _o_.usedbirdnum) return false;
/* 1207 */       if (this.freerefreshcount != _o_.freerefreshcount) return false;
/* 1208 */       if (this.preguaranteecount != _o_.preguaranteecount) return false;
/* 1209 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1215 */       int _h_ = 0;
/* 1216 */       _h_ += this.bountycount;
/* 1217 */       _h_ += this.taskinfos.hashCode();
/* 1218 */       _h_ += this.donetaskinfo.hashCode();
/* 1219 */       _h_ += this.usedbirdnum;
/* 1220 */       _h_ += this.freerefreshcount;
/* 1221 */       _h_ += this.preguaranteecount;
/* 1222 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1228 */       StringBuilder _sb_ = new StringBuilder();
/* 1229 */       _sb_.append("(");
/* 1230 */       _sb_.append(this.bountycount);
/* 1231 */       _sb_.append(",");
/* 1232 */       _sb_.append(this.taskinfos);
/* 1233 */       _sb_.append(",");
/* 1234 */       _sb_.append(this.donetaskinfo);
/* 1235 */       _sb_.append(",");
/* 1236 */       _sb_.append(this.usedbirdnum);
/* 1237 */       _sb_.append(",");
/* 1238 */       _sb_.append(this.freerefreshcount);
/* 1239 */       _sb_.append(",");
/* 1240 */       _sb_.append(this.preguaranteecount);
/* 1241 */       _sb_.append(")");
/* 1242 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BountyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */