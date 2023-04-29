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
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class GrabPositionData extends XBean implements xbean.GrabPositionData
/*      */ {
/*      */   private int state;
/*      */   private xbean.GrabPositionSessions sessiondata;
/*      */   private long firstgrabroleid;
/*      */   private long firstgrabtime;
/*      */   private HashMap<Long, xbean.RoleGrabPositionData> role2grabdata;
/*      */   private int campid;
/*      */   private long instanceid;
/*      */   private long grabingroleid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.state = 0;
/*   33 */     this.sessiondata._reset_unsafe_();
/*   34 */     this.firstgrabroleid = 0L;
/*   35 */     this.firstgrabtime = 0L;
/*   36 */     this.role2grabdata.clear();
/*   37 */     this.campid = 0;
/*   38 */     this.instanceid = 0L;
/*   39 */     this.grabingroleid = 0L;
/*      */   }
/*      */   
/*      */   GrabPositionData(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.sessiondata = new GrabPositionSessions(0, this, "sessiondata");
/*   46 */     this.role2grabdata = new HashMap();
/*      */   }
/*      */   
/*      */   public GrabPositionData()
/*      */   {
/*   51 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public GrabPositionData(GrabPositionData _o_)
/*      */   {
/*   56 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   GrabPositionData(xbean.GrabPositionData _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   61 */     super(_xp_, _vn_);
/*   62 */     if ((_o1_ instanceof GrabPositionData)) { assign((GrabPositionData)_o1_);
/*   63 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   64 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   65 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(GrabPositionData _o_) {
/*   70 */     _o_._xdb_verify_unsafe_();
/*   71 */     this.state = _o_.state;
/*   72 */     this.sessiondata = new GrabPositionSessions(_o_.sessiondata, this, "sessiondata");
/*   73 */     this.firstgrabroleid = _o_.firstgrabroleid;
/*   74 */     this.firstgrabtime = _o_.firstgrabtime;
/*   75 */     this.role2grabdata = new HashMap();
/*   76 */     for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : _o_.role2grabdata.entrySet())
/*   77 */       this.role2grabdata.put(_e_.getKey(), new RoleGrabPositionData((xbean.RoleGrabPositionData)_e_.getValue(), this, "role2grabdata"));
/*   78 */     this.campid = _o_.campid;
/*   79 */     this.instanceid = _o_.instanceid;
/*   80 */     this.grabingroleid = _o_.grabingroleid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   85 */     this.state = _o_.state;
/*   86 */     this.sessiondata = new GrabPositionSessions(_o_.sessiondata, this, "sessiondata");
/*   87 */     this.firstgrabroleid = _o_.firstgrabroleid;
/*   88 */     this.firstgrabtime = _o_.firstgrabtime;
/*   89 */     this.role2grabdata = new HashMap();
/*   90 */     for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : _o_.role2grabdata.entrySet())
/*   91 */       this.role2grabdata.put(_e_.getKey(), new RoleGrabPositionData((xbean.RoleGrabPositionData)_e_.getValue(), this, "role2grabdata"));
/*   92 */     this.campid = _o_.campid;
/*   93 */     this.instanceid = _o_.instanceid;
/*   94 */     this.grabingroleid = _o_.grabingroleid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  100 */     _xdb_verify_unsafe_();
/*  101 */     _os_.marshal(this.state);
/*  102 */     this.sessiondata.marshal(_os_);
/*  103 */     _os_.marshal(this.firstgrabroleid);
/*  104 */     _os_.marshal(this.firstgrabtime);
/*  105 */     _os_.compact_uint32(this.role2grabdata.size());
/*  106 */     for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : this.role2grabdata.entrySet())
/*      */     {
/*  108 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  109 */       ((xbean.RoleGrabPositionData)_e_.getValue()).marshal(_os_);
/*      */     }
/*  111 */     _os_.marshal(this.campid);
/*  112 */     _os_.marshal(this.instanceid);
/*  113 */     _os_.marshal(this.grabingroleid);
/*  114 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  120 */     _xdb_verify_unsafe_();
/*  121 */     this.state = _os_.unmarshal_int();
/*  122 */     this.sessiondata.unmarshal(_os_);
/*  123 */     this.firstgrabroleid = _os_.unmarshal_long();
/*  124 */     this.firstgrabtime = _os_.unmarshal_long();
/*      */     
/*  126 */     int size = _os_.uncompact_uint32();
/*  127 */     if (size >= 12)
/*      */     {
/*  129 */       this.role2grabdata = new HashMap(size * 2);
/*      */     }
/*  131 */     for (; size > 0; size--)
/*      */     {
/*  133 */       long _k_ = 0L;
/*  134 */       _k_ = _os_.unmarshal_long();
/*  135 */       xbean.RoleGrabPositionData _v_ = new RoleGrabPositionData(0, this, "role2grabdata");
/*  136 */       _v_.unmarshal(_os_);
/*  137 */       this.role2grabdata.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  140 */     this.campid = _os_.unmarshal_int();
/*  141 */     this.instanceid = _os_.unmarshal_long();
/*  142 */     this.grabingroleid = _os_.unmarshal_long();
/*  143 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  149 */     _xdb_verify_unsafe_();
/*  150 */     int _size_ = 0;
/*  151 */     _size_ += CodedOutputStream.computeInt32Size(1, this.state);
/*  152 */     _size_ += CodedOutputStream.computeMessageSize(2, this.sessiondata);
/*  153 */     _size_ += CodedOutputStream.computeInt64Size(3, this.firstgrabroleid);
/*  154 */     _size_ += CodedOutputStream.computeInt64Size(4, this.firstgrabtime);
/*  155 */     for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : this.role2grabdata.entrySet())
/*      */     {
/*  157 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  158 */       _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */     }
/*  160 */     _size_ += CodedOutputStream.computeInt32Size(6, this.campid);
/*  161 */     _size_ += CodedOutputStream.computeInt64Size(7, this.instanceid);
/*  162 */     _size_ += CodedOutputStream.computeInt64Size(8, this.grabingroleid);
/*  163 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  169 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  172 */       _output_.writeInt32(1, this.state);
/*  173 */       _output_.writeMessage(2, this.sessiondata);
/*  174 */       _output_.writeInt64(3, this.firstgrabroleid);
/*  175 */       _output_.writeInt64(4, this.firstgrabtime);
/*  176 */       for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : this.role2grabdata.entrySet())
/*      */       {
/*  178 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  179 */         _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  181 */       _output_.writeInt32(6, this.campid);
/*  182 */       _output_.writeInt64(7, this.instanceid);
/*  183 */       _output_.writeInt64(8, this.grabingroleid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  187 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  189 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  195 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  198 */       boolean done = false;
/*  199 */       while (!done)
/*      */       {
/*  201 */         int tag = _input_.readTag();
/*  202 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  206 */           done = true;
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  211 */           this.state = _input_.readInt32();
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  216 */           _input_.readMessage(this.sessiondata);
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  221 */           this.firstgrabroleid = _input_.readInt64();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  226 */           this.firstgrabtime = _input_.readInt64();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  231 */           long _k_ = 0L;
/*  232 */           _k_ = _input_.readInt64();
/*  233 */           int readTag = _input_.readTag();
/*  234 */           if (42 != readTag)
/*      */           {
/*  236 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  238 */           xbean.RoleGrabPositionData _v_ = new RoleGrabPositionData(0, this, "role2grabdata");
/*  239 */           _input_.readMessage(_v_);
/*  240 */           this.role2grabdata.put(Long.valueOf(_k_), _v_);
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  245 */           this.campid = _input_.readInt32();
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  250 */           this.instanceid = _input_.readInt64();
/*  251 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  255 */           this.grabingroleid = _input_.readInt64();
/*  256 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  260 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  262 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  271 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  275 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  277 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GrabPositionData copy()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new GrabPositionData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GrabPositionData toData()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GrabPositionData toBean()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return new GrabPositionData(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.GrabPositionData toDataIf()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.GrabPositionData toBeanIf()
/*      */   {
/*  309 */     _xdb_verify_unsafe_();
/*  310 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.GrabPositionSessions getSessiondata()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return this.sessiondata;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFirstgrabroleid()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return this.firstgrabroleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFirstgrabtime()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return this.firstgrabtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleGrabPositionData> getRole2grabdata()
/*      */   {
/*  356 */     _xdb_verify_unsafe_();
/*  357 */     return Logs.logMap(new LogKey(this, "role2grabdata"), this.role2grabdata);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleGrabPositionData> getRole2grabdataAsData()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*      */     
/*  366 */     GrabPositionData _o_ = this;
/*  367 */     Map<Long, xbean.RoleGrabPositionData> role2grabdata = new HashMap();
/*  368 */     for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : _o_.role2grabdata.entrySet())
/*  369 */       role2grabdata.put(_e_.getKey(), new RoleGrabPositionData.Data((xbean.RoleGrabPositionData)_e_.getValue()));
/*  370 */     return role2grabdata;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCampid()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return this.campid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getInstanceid()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return this.instanceid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGrabingroleid()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return this.grabingroleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  406 */         new xdb.logs.LogInt(this, GrabPositionData.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  410 */             GrabPositionData.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  414 */     });
/*  415 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFirstgrabroleid(long _v_)
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     Logs.logIf(new LogKey(this, "firstgrabroleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  427 */         new LogLong(this, GrabPositionData.this.firstgrabroleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  431 */             GrabPositionData.this.firstgrabroleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  435 */     });
/*  436 */     this.firstgrabroleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFirstgrabtime(long _v_)
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     Logs.logIf(new LogKey(this, "firstgrabtime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  448 */         new LogLong(this, GrabPositionData.this.firstgrabtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  452 */             GrabPositionData.this.firstgrabtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  456 */     });
/*  457 */     this.firstgrabtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCampid(int _v_)
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     Logs.logIf(new LogKey(this, "campid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  469 */         new xdb.logs.LogInt(this, GrabPositionData.this.campid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  473 */             GrabPositionData.this.campid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  477 */     });
/*  478 */     this.campid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setInstanceid(long _v_)
/*      */   {
/*  485 */     _xdb_verify_unsafe_();
/*  486 */     Logs.logIf(new LogKey(this, "instanceid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  490 */         new LogLong(this, GrabPositionData.this.instanceid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  494 */             GrabPositionData.this.instanceid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  498 */     });
/*  499 */     this.instanceid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrabingroleid(long _v_)
/*      */   {
/*  506 */     _xdb_verify_unsafe_();
/*  507 */     Logs.logIf(new LogKey(this, "grabingroleid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  511 */         new LogLong(this, GrabPositionData.this.grabingroleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  515 */             GrabPositionData.this.grabingroleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  519 */     });
/*  520 */     this.grabingroleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     GrabPositionData _o_ = null;
/*  528 */     if ((_o1_ instanceof GrabPositionData)) { _o_ = (GrabPositionData)_o1_;
/*  529 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  530 */       return false;
/*  531 */     if (this.state != _o_.state) return false;
/*  532 */     if (!this.sessiondata.equals(_o_.sessiondata)) return false;
/*  533 */     if (this.firstgrabroleid != _o_.firstgrabroleid) return false;
/*  534 */     if (this.firstgrabtime != _o_.firstgrabtime) return false;
/*  535 */     if (!this.role2grabdata.equals(_o_.role2grabdata)) return false;
/*  536 */     if (this.campid != _o_.campid) return false;
/*  537 */     if (this.instanceid != _o_.instanceid) return false;
/*  538 */     if (this.grabingroleid != _o_.grabingroleid) return false;
/*  539 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  545 */     _xdb_verify_unsafe_();
/*  546 */     int _h_ = 0;
/*  547 */     _h_ += this.state;
/*  548 */     _h_ += this.sessiondata.hashCode();
/*  549 */     _h_ = (int)(_h_ + this.firstgrabroleid);
/*  550 */     _h_ = (int)(_h_ + this.firstgrabtime);
/*  551 */     _h_ += this.role2grabdata.hashCode();
/*  552 */     _h_ += this.campid;
/*  553 */     _h_ = (int)(_h_ + this.instanceid);
/*  554 */     _h_ = (int)(_h_ + this.grabingroleid);
/*  555 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  561 */     _xdb_verify_unsafe_();
/*  562 */     StringBuilder _sb_ = new StringBuilder();
/*  563 */     _sb_.append("(");
/*  564 */     _sb_.append(this.state);
/*  565 */     _sb_.append(",");
/*  566 */     _sb_.append(this.sessiondata);
/*  567 */     _sb_.append(",");
/*  568 */     _sb_.append(this.firstgrabroleid);
/*  569 */     _sb_.append(",");
/*  570 */     _sb_.append(this.firstgrabtime);
/*  571 */     _sb_.append(",");
/*  572 */     _sb_.append(this.role2grabdata);
/*  573 */     _sb_.append(",");
/*  574 */     _sb_.append(this.campid);
/*  575 */     _sb_.append(",");
/*  576 */     _sb_.append(this.instanceid);
/*  577 */     _sb_.append(",");
/*  578 */     _sb_.append(this.grabingroleid);
/*  579 */     _sb_.append(")");
/*  580 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  586 */     ListenableBean lb = new ListenableBean();
/*  587 */     lb.add(new ListenableChanged().setVarName("state"));
/*  588 */     lb.add(new ListenableChanged().setVarName("sessiondata"));
/*  589 */     lb.add(new ListenableChanged().setVarName("firstgrabroleid"));
/*  590 */     lb.add(new ListenableChanged().setVarName("firstgrabtime"));
/*  591 */     lb.add(new xdb.logs.ListenableMap().setVarName("role2grabdata"));
/*  592 */     lb.add(new ListenableChanged().setVarName("campid"));
/*  593 */     lb.add(new ListenableChanged().setVarName("instanceid"));
/*  594 */     lb.add(new ListenableChanged().setVarName("grabingroleid"));
/*  595 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.GrabPositionData {
/*      */     private Const() {}
/*      */     
/*      */     GrabPositionData nThis() {
/*  602 */       return GrabPositionData.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GrabPositionData copy()
/*      */     {
/*  614 */       return GrabPositionData.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GrabPositionData toData()
/*      */     {
/*  620 */       return GrabPositionData.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.GrabPositionData toBean()
/*      */     {
/*  625 */       return GrabPositionData.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GrabPositionData toDataIf()
/*      */     {
/*  631 */       return GrabPositionData.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.GrabPositionData toBeanIf()
/*      */     {
/*  636 */       return GrabPositionData.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  643 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  644 */       return GrabPositionData.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.GrabPositionSessions getSessiondata()
/*      */     {
/*  651 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  652 */       return (xbean.GrabPositionSessions)xdb.Consts.toConst(GrabPositionData.this.sessiondata);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFirstgrabroleid()
/*      */     {
/*  659 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  660 */       return GrabPositionData.this.firstgrabroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFirstgrabtime()
/*      */     {
/*  667 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  668 */       return GrabPositionData.this.firstgrabtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleGrabPositionData> getRole2grabdata()
/*      */     {
/*  675 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  676 */       return xdb.Consts.constMap(GrabPositionData.this.role2grabdata);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleGrabPositionData> getRole2grabdataAsData()
/*      */     {
/*  683 */       GrabPositionData.this._xdb_verify_unsafe_();
/*      */       
/*  685 */       GrabPositionData _o_ = GrabPositionData.this;
/*  686 */       Map<Long, xbean.RoleGrabPositionData> role2grabdata = new HashMap();
/*  687 */       for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : _o_.role2grabdata.entrySet())
/*  688 */         role2grabdata.put(_e_.getKey(), new RoleGrabPositionData.Data((xbean.RoleGrabPositionData)_e_.getValue()));
/*  689 */       return role2grabdata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCampid()
/*      */     {
/*  696 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  697 */       return GrabPositionData.this.campid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInstanceid()
/*      */     {
/*  704 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  705 */       return GrabPositionData.this.instanceid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrabingroleid()
/*      */     {
/*  712 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  713 */       return GrabPositionData.this.grabingroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  720 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  721 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirstgrabroleid(long _v_)
/*      */     {
/*  728 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  729 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirstgrabtime(long _v_)
/*      */     {
/*  736 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  737 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCampid(int _v_)
/*      */     {
/*  744 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  745 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInstanceid(long _v_)
/*      */     {
/*  752 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  753 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrabingroleid(long _v_)
/*      */     {
/*  760 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  761 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  767 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  768 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  774 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  775 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  781 */       return GrabPositionData.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  787 */       return GrabPositionData.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  793 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  794 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  800 */       return GrabPositionData.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  806 */       return GrabPositionData.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  812 */       GrabPositionData.this._xdb_verify_unsafe_();
/*  813 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  819 */       return GrabPositionData.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  825 */       return GrabPositionData.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  831 */       return GrabPositionData.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  837 */       return GrabPositionData.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  843 */       return GrabPositionData.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  849 */       return GrabPositionData.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  855 */       return GrabPositionData.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.GrabPositionData
/*      */   {
/*      */     private int state;
/*      */     
/*      */     private xbean.GrabPositionSessions sessiondata;
/*      */     
/*      */     private long firstgrabroleid;
/*      */     
/*      */     private long firstgrabtime;
/*      */     
/*      */     private HashMap<Long, xbean.RoleGrabPositionData> role2grabdata;
/*      */     
/*      */     private int campid;
/*      */     
/*      */     private long instanceid;
/*      */     
/*      */     private long grabingroleid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  881 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  886 */       this.sessiondata = new GrabPositionSessions.Data();
/*  887 */       this.role2grabdata = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.GrabPositionData _o1_)
/*      */     {
/*  892 */       if ((_o1_ instanceof GrabPositionData)) { assign((GrabPositionData)_o1_);
/*  893 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  894 */       } else if ((_o1_ instanceof GrabPositionData.Const)) assign(((GrabPositionData.Const)_o1_).nThis()); else {
/*  895 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(GrabPositionData _o_) {
/*  900 */       this.state = _o_.state;
/*  901 */       this.sessiondata = new GrabPositionSessions.Data(_o_.sessiondata);
/*  902 */       this.firstgrabroleid = _o_.firstgrabroleid;
/*  903 */       this.firstgrabtime = _o_.firstgrabtime;
/*  904 */       this.role2grabdata = new HashMap();
/*  905 */       for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : _o_.role2grabdata.entrySet())
/*  906 */         this.role2grabdata.put(_e_.getKey(), new RoleGrabPositionData.Data((xbean.RoleGrabPositionData)_e_.getValue()));
/*  907 */       this.campid = _o_.campid;
/*  908 */       this.instanceid = _o_.instanceid;
/*  909 */       this.grabingroleid = _o_.grabingroleid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  914 */       this.state = _o_.state;
/*  915 */       this.sessiondata = new GrabPositionSessions.Data(_o_.sessiondata);
/*  916 */       this.firstgrabroleid = _o_.firstgrabroleid;
/*  917 */       this.firstgrabtime = _o_.firstgrabtime;
/*  918 */       this.role2grabdata = new HashMap();
/*  919 */       for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : _o_.role2grabdata.entrySet())
/*  920 */         this.role2grabdata.put(_e_.getKey(), new RoleGrabPositionData.Data((xbean.RoleGrabPositionData)_e_.getValue()));
/*  921 */       this.campid = _o_.campid;
/*  922 */       this.instanceid = _o_.instanceid;
/*  923 */       this.grabingroleid = _o_.grabingroleid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  929 */       _os_.marshal(this.state);
/*  930 */       this.sessiondata.marshal(_os_);
/*  931 */       _os_.marshal(this.firstgrabroleid);
/*  932 */       _os_.marshal(this.firstgrabtime);
/*  933 */       _os_.compact_uint32(this.role2grabdata.size());
/*  934 */       for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : this.role2grabdata.entrySet())
/*      */       {
/*  936 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  937 */         ((xbean.RoleGrabPositionData)_e_.getValue()).marshal(_os_);
/*      */       }
/*  939 */       _os_.marshal(this.campid);
/*  940 */       _os_.marshal(this.instanceid);
/*  941 */       _os_.marshal(this.grabingroleid);
/*  942 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  948 */       this.state = _os_.unmarshal_int();
/*  949 */       this.sessiondata.unmarshal(_os_);
/*  950 */       this.firstgrabroleid = _os_.unmarshal_long();
/*  951 */       this.firstgrabtime = _os_.unmarshal_long();
/*      */       
/*  953 */       int size = _os_.uncompact_uint32();
/*  954 */       if (size >= 12)
/*      */       {
/*  956 */         this.role2grabdata = new HashMap(size * 2);
/*      */       }
/*  958 */       for (; size > 0; size--)
/*      */       {
/*  960 */         long _k_ = 0L;
/*  961 */         _k_ = _os_.unmarshal_long();
/*  962 */         xbean.RoleGrabPositionData _v_ = xbean.Pod.newRoleGrabPositionDataData();
/*  963 */         _v_.unmarshal(_os_);
/*  964 */         this.role2grabdata.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  967 */       this.campid = _os_.unmarshal_int();
/*  968 */       this.instanceid = _os_.unmarshal_long();
/*  969 */       this.grabingroleid = _os_.unmarshal_long();
/*  970 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  976 */       int _size_ = 0;
/*  977 */       _size_ += CodedOutputStream.computeInt32Size(1, this.state);
/*  978 */       _size_ += CodedOutputStream.computeMessageSize(2, this.sessiondata);
/*  979 */       _size_ += CodedOutputStream.computeInt64Size(3, this.firstgrabroleid);
/*  980 */       _size_ += CodedOutputStream.computeInt64Size(4, this.firstgrabtime);
/*  981 */       for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : this.role2grabdata.entrySet())
/*      */       {
/*  983 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  984 */         _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  986 */       _size_ += CodedOutputStream.computeInt32Size(6, this.campid);
/*  987 */       _size_ += CodedOutputStream.computeInt64Size(7, this.instanceid);
/*  988 */       _size_ += CodedOutputStream.computeInt64Size(8, this.grabingroleid);
/*  989 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  997 */         _output_.writeInt32(1, this.state);
/*  998 */         _output_.writeMessage(2, this.sessiondata);
/*  999 */         _output_.writeInt64(3, this.firstgrabroleid);
/* 1000 */         _output_.writeInt64(4, this.firstgrabtime);
/* 1001 */         for (Map.Entry<Long, xbean.RoleGrabPositionData> _e_ : this.role2grabdata.entrySet())
/*      */         {
/* 1003 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/* 1004 */           _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1006 */         _output_.writeInt32(6, this.campid);
/* 1007 */         _output_.writeInt64(7, this.instanceid);
/* 1008 */         _output_.writeInt64(8, this.grabingroleid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1012 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1014 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1022 */         boolean done = false;
/* 1023 */         while (!done)
/*      */         {
/* 1025 */           int tag = _input_.readTag();
/* 1026 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1030 */             done = true;
/* 1031 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1035 */             this.state = _input_.readInt32();
/* 1036 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/* 1040 */             _input_.readMessage(this.sessiondata);
/* 1041 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1045 */             this.firstgrabroleid = _input_.readInt64();
/* 1046 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1050 */             this.firstgrabtime = _input_.readInt64();
/* 1051 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1055 */             long _k_ = 0L;
/* 1056 */             _k_ = _input_.readInt64();
/* 1057 */             int readTag = _input_.readTag();
/* 1058 */             if (42 != readTag)
/*      */             {
/* 1060 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1062 */             xbean.RoleGrabPositionData _v_ = xbean.Pod.newRoleGrabPositionDataData();
/* 1063 */             _input_.readMessage(_v_);
/* 1064 */             this.role2grabdata.put(Long.valueOf(_k_), _v_);
/* 1065 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1069 */             this.campid = _input_.readInt32();
/* 1070 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1074 */             this.instanceid = _input_.readInt64();
/* 1075 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1079 */             this.grabingroleid = _input_.readInt64();
/* 1080 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1084 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1086 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1095 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1099 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1101 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GrabPositionData copy()
/*      */     {
/* 1107 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GrabPositionData toData()
/*      */     {
/* 1113 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.GrabPositionData toBean()
/*      */     {
/* 1118 */       return new GrabPositionData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.GrabPositionData toDataIf()
/*      */     {
/* 1124 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.GrabPositionData toBeanIf()
/*      */     {
/* 1129 */       return new GrabPositionData(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1135 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1139 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1143 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1147 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1151 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1155 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1159 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1166 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.GrabPositionSessions getSessiondata()
/*      */     {
/* 1173 */       return this.sessiondata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFirstgrabroleid()
/*      */     {
/* 1180 */       return this.firstgrabroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFirstgrabtime()
/*      */     {
/* 1187 */       return this.firstgrabtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleGrabPositionData> getRole2grabdata()
/*      */     {
/* 1194 */       return this.role2grabdata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleGrabPositionData> getRole2grabdataAsData()
/*      */     {
/* 1201 */       return this.role2grabdata;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCampid()
/*      */     {
/* 1208 */       return this.campid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getInstanceid()
/*      */     {
/* 1215 */       return this.instanceid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrabingroleid()
/*      */     {
/* 1222 */       return this.grabingroleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1229 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirstgrabroleid(long _v_)
/*      */     {
/* 1236 */       this.firstgrabroleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirstgrabtime(long _v_)
/*      */     {
/* 1243 */       this.firstgrabtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCampid(int _v_)
/*      */     {
/* 1250 */       this.campid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setInstanceid(long _v_)
/*      */     {
/* 1257 */       this.instanceid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrabingroleid(long _v_)
/*      */     {
/* 1264 */       this.grabingroleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1270 */       if (!(_o1_ instanceof Data)) return false;
/* 1271 */       Data _o_ = (Data)_o1_;
/* 1272 */       if (this.state != _o_.state) return false;
/* 1273 */       if (!this.sessiondata.equals(_o_.sessiondata)) return false;
/* 1274 */       if (this.firstgrabroleid != _o_.firstgrabroleid) return false;
/* 1275 */       if (this.firstgrabtime != _o_.firstgrabtime) return false;
/* 1276 */       if (!this.role2grabdata.equals(_o_.role2grabdata)) return false;
/* 1277 */       if (this.campid != _o_.campid) return false;
/* 1278 */       if (this.instanceid != _o_.instanceid) return false;
/* 1279 */       if (this.grabingroleid != _o_.grabingroleid) return false;
/* 1280 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1286 */       int _h_ = 0;
/* 1287 */       _h_ += this.state;
/* 1288 */       _h_ += this.sessiondata.hashCode();
/* 1289 */       _h_ = (int)(_h_ + this.firstgrabroleid);
/* 1290 */       _h_ = (int)(_h_ + this.firstgrabtime);
/* 1291 */       _h_ += this.role2grabdata.hashCode();
/* 1292 */       _h_ += this.campid;
/* 1293 */       _h_ = (int)(_h_ + this.instanceid);
/* 1294 */       _h_ = (int)(_h_ + this.grabingroleid);
/* 1295 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1301 */       StringBuilder _sb_ = new StringBuilder();
/* 1302 */       _sb_.append("(");
/* 1303 */       _sb_.append(this.state);
/* 1304 */       _sb_.append(",");
/* 1305 */       _sb_.append(this.sessiondata);
/* 1306 */       _sb_.append(",");
/* 1307 */       _sb_.append(this.firstgrabroleid);
/* 1308 */       _sb_.append(",");
/* 1309 */       _sb_.append(this.firstgrabtime);
/* 1310 */       _sb_.append(",");
/* 1311 */       _sb_.append(this.role2grabdata);
/* 1312 */       _sb_.append(",");
/* 1313 */       _sb_.append(this.campid);
/* 1314 */       _sb_.append(",");
/* 1315 */       _sb_.append(this.instanceid);
/* 1316 */       _sb_.append(",");
/* 1317 */       _sb_.append(this.grabingroleid);
/* 1318 */       _sb_.append(")");
/* 1319 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GrabPositionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */